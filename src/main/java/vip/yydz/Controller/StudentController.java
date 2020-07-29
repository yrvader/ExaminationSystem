package vip.yydz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vip.yydz.domain.*;
import vip.yydz.service.ExaminationService;
import vip.yydz.service.StudentService;
import vip.yydz.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @Autowired
    private ExaminationService examinationService;
    /**
     * 前往登录界面
     * @return
     */
    @RequestMapping(value = "login")
    public String stulogin()
    {
        return "stu/login";
    }
    @RequestMapping(value = "logincheck")
    public ModelAndView logincheck(Student student, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(student);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andPasswordEqualTo(student.getPassword());
        studentExample.createCriteria().andStunumberEqualTo(student.getStunumber());
        List<Student> students = studentService.selectByExampleWithTest(studentExample);
        if (!students.isEmpty()) {
            modelAndView.setViewName("redirect:/tostu");//重定向管理首页
            session.setAttribute("stu", students.get(0));//封装学生
            //model目的就是把数据封装在  request对象里传递,
        } else {//不存在
            modelAndView.setViewName("redirect:login");//返回登录页
            modelAndView.addObject("msg","用户名或密码错误");
        }
        return modelAndView;
    }
    /**
     * 转到学生主界面
     * @return
     */
    @RequestMapping(value = "/tostu")
    public String tostu(){
        return "stu/stu";
    }
    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        //退出登录的本质就是对session数据的销毁
        session.invalidate();
        return "redirect:login";
    }
    /**
     * 跳转到更新密码的界面
     * @return
     */
    @RequestMapping(value = "/toupdatepassword")
    public ModelAndView  toupadtepassword(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("stu/updatepassword");
        return modelAndView;
    }

    /**
     * 执行更新密码的操作并返回到成功界面
     * @param student
     * @param session
     * @return
     */
    @RequestMapping(value = "updatepassword")
    public String upadteoassword(Student student,HttpSession session){
        System.out.println(student);
        studentService.updateByPrimaryKeySelective(student);
        student= studentService.selectByPrimaryKey(student.getStuid());
        session.setAttribute("stu",student);//更新session
        return "stu/success";//返回到显示成功的界面
    }
    /**
     * 转到未提交试卷界面
     * @param stuid
     * @return
     */
    @RequestMapping(value = "tounfinishedlist")
    public ModelAndView tounfinishedlist(Integer stuid)
    {
        ModelAndView modelAndView=new ModelAndView();
        TestExample example=new TestExample();
        example.createCriteria().andIsubmitEqualTo(false);
        example.createCriteria().andTestfkEqualTo(stuid);
        List<Test> tests=testService.selectByExample(example);//搜索
        modelAndView.addObject("tests" ,tests);//给页面一个test的集合
        modelAndView.addObject("date",new Date());//当前时间
        modelAndView.setViewName("stu/unfinishedExamlist");
        return modelAndView;
    }

    /**
     * 转到更新图片的界面
     * @param testid 要更新的试卷
     * @param session 好像没啥用
     * @return
     */
    @RequestMapping(value = "/touploadExam")
    public ModelAndView touploadExam(Integer testid,HttpSession session){
        Test test=testService.selectByPrimaryKey(testid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("test",test);
        String[] paths=testService.getPaths(test);
        System.out.println(test);
        System.out.println(testService.getPaths(test));
        session.setAttribute("test",test);
        modelAndView.addObject("paths",paths);
        modelAndView.setViewName("/stu/uploadExam");
        return modelAndView;
    }

    /**
     * 执行更新图片的操作
     * @param file
     * @param testid
     * @param i
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadExam")
    public ModelAndView update(@RequestParam(value = "file") MultipartFile file,Integer testid ,Integer i,HttpServletRequest request) throws IOException {
        Test test=testService.selectByPrimaryKey(testid);
        String path="D:\\study\\HIT\\upload";
        String filename = testid + "-"+i + file.getOriginalFilename();
        File file1 = new File(path, filename);
        if(!file1.exists()){
            file1.mkdirs();
        }
        file.transferTo(file1);
        String photoUrl="images/upload/"+filename;
        test=testService.updateIthPath(i,test,photoUrl);
        ModelAndView modelAndView = new ModelAndView("stu/uploadExam");
        modelAndView.addObject("test",test);//设置新的test
        modelAndView.addObject("paths",testService.getPaths(test));
        TestExample testExample=new TestExample();
        return modelAndView;
    }

    /**
     * 提交试卷
     * @param testid
     * @return
     */
    @RequestMapping(value = "submit")
    public String submit(Integer testid){
        Test test=testService.selectByPrimaryKey(testid);
        test.setIsubmit(true);
        testService.updateByPrimaryKey(test);
        return"stu/success";
    }
    @RequestMapping(value = "tocheckscore")
    public ModelAndView tocheckScore(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("/stu/checkscore");
        Student student=(Student)session.getAttribute("stu");
        TestExample example=new TestExample();
        example.createCriteria().andIsubmitEqualTo(true);
        example.createCriteria().andTestfkEqualTo(student.getStuid());
        List<Test> tests=testService.selectByExample(example);
        System.out.println(tests);
        modelAndView.addObject("tests",tests);
        List<Integer> scores=new ArrayList<>();
        for(int i=0;i<tests.size();i++)
        {
            int sum=0;
            String[] list=tests.get(i).getScores().split(",");
            for(int j=0;j<list.length;j++)
            {
                System.out.println(list[j]);
                sum=sum+Integer.valueOf(list[j].split("=")[1]);
            }
            scores.add(sum);
        }
        modelAndView.addObject("scores",scores);
        return modelAndView;
    }



}
