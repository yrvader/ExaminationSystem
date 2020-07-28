package vip.yydz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vip.yydz.domain.Student;
import vip.yydz.domain.Test;
import vip.yydz.domain.TestExample;
import vip.yydz.service.ExaminationService;
import vip.yydz.service.StudentService;
import vip.yydz.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @Autowired
    private ExaminationService examinationService;
    @RequestMapping(value = "/toupdatepassword")
    public ModelAndView  toupadtepassword(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("stu/updatepassword");
        return modelAndView;
    }
    @RequestMapping(value = "updatepassword")
    public String upadteoassword(Student student,HttpSession session){
        System.out.println(student);
        studentService.updateByPrimaryKeySelective(student);
        student= studentService.selectByPrimaryKey(student.getStuid());
        session.setAttribute("stu",student);
        return "stu/success";
    }
    @RequestMapping(value = "tounfinishedlist")
    public ModelAndView tounfinishedlist(Integer stuid)
    {
        ModelAndView modelAndView=new ModelAndView();
        TestExample example=new TestExample();
        example.createCriteria().andIsubmitEqualTo(false);
        example.createCriteria().andTestfkEqualTo(stuid);
        List<Test> tests=testService.selectByExample(example);
        modelAndView.addObject("tests" ,tests);//给页面一个test的集合
        modelAndView.addObject("date",new Date());
        modelAndView.setViewName("stu/unfinishedExamlist");
        return modelAndView;
    }
    @RequestMapping(value = "/touploadExam")
    public ModelAndView touploadExam(Integer testid,HttpSession session){
        Test test=testService.selectByPrimaryKey(testid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("test",test);
        String[] paths=testService.getPaths(test);
        System.out.println(test);
        System.out.println(testService.getPaths(test));
        modelAndView.addObject("paths",paths);
        modelAndView.setViewName("/stu/uploadExam");
        return modelAndView;
    }
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
//        System.out.println(file);
//        for(int j=0;j<file.length;j++){
//            System.out.println(file[j]);
//            String filename = testid + "-"+j + file[j].getOriginalFilename();
//            File file1 = new File(path, filename);
//            if(!file1.exists()){
//                file1.mkdirs();
//            }
//            file[j].transferTo(file1);
//            String photoUrl="images/upload/"+filename;
//            test=testService.updateIthPath(j+1,test,photoUrl);
//        }
        ModelAndView modelAndView = new ModelAndView("stu/uploadExam");
        modelAndView.addObject("test",test);
        modelAndView.addObject("paths",testService.getPaths(test));
        TestExample testExample=new TestExample();
        return modelAndView;
    }
//    @RequestMapping(value = "addpicture")
//    public ModelAndView addpicture(@RequestParam(value = "file") MultipartFile file,Integer testid ,HttpServletRequest request) throws IOException {
//        Test test=testService.selectByPrimaryKey(testid);
//        System.out.println(testid);
//        String path="D:\\study\\HIT\\upload";
//        String filename = testid + "-"+ file.getOriginalFilename();
//        File file1 = new File(path, filename);
//        if(!file1.exists()){
//            file1.mkdirs();
//        }
//        file.transferTo(file1);
//        String photoUrl="images/upload/"+filename;
//        System.out.println(photoUrl);
//        test=testService.addPath(test.getTestid(),photoUrl);
//        ModelAndView modelAndView = new ModelAndView("stu/uploadExam");
//        modelAndView.addObject("test",test);
//        modelAndView.addObject("paths",testService.getPaths(test));
//        TestExample testExample=new TestExample();
//        return modelAndView;
//    }
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
