package vip.yydz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vip.yydz.domain.Student;
import vip.yydz.domain.StudentExample;
import vip.yydz.domain.Test;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.yydz.domain.*;
import vip.yydz.service.ExaminationService;
import vip.yydz.service.StudentService;
import vip.yydz.service.TestService;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    static private String username="admin";
    static private String password="123456";
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @Autowired
    private ExaminationService examinationService;

    /**
     * 检查参数并跳转，都是重定向的
     * @param student
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginCheck")
    public ModelAndView loginCheck(Student student, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (username.equals(student.getStunumber()) && password.equals(student.getPassword())) {
            session.setAttribute("admin",new AdminController());
            modelAndView.setViewName("redirect:/admin/admin");
        } else {
            modelAndView.setViewName("redirect:/admin/login");//返回登录页
        }
        return modelAndView;
    }
    @RequestMapping(value = "/admin")
    public String damin(){
        return "admin/admin";
    }

    /**
     * 到管理员的登录界面
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){//先改为到管理员
        return "admin/login";
    }

    /**
     * 登出重新跳转到登录页
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //退出登录的本质就是对session数据的销毁
        session.invalidate();
        return "redirect:/admin/login";
    }

//    @RequestMapping(value = "/toAdmin")应该用不上了
//    public String toAdmin(){
//        return "admin/adminLogin";
//    }

    /**
     * 跳转到学生列表
     * @return
     */
    @RequestMapping(value = "/Listofstudent")
    public ModelAndView studentList(){
        ModelAndView modelAndView = new ModelAndView("admin/studentList");
        StudentExample se = new StudentExample();
        se.createCriteria().andStuidIsNotNull();
        List<Student> students = studentService.selectByExample(se);
        modelAndView.addObject("students",students);
        return modelAndView;
    }

    /**
     * 删除学生
     * @param stuid
     * @return
     */
    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Integer stuid){
        TestExample example=new TestExample();
        example.createCriteria().andTestfkEqualTo(stuid);
        testService.deleteByExample(example);//先删掉外面的
        ModelAndView modelAndView = new ModelAndView("redirect:Listofstudent");
        studentService.deleteByPrimaryKey(stuid);
        return modelAndView;
    }

    /**
     * 删除考试
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteexam")
    public ModelAndView deleteexam(Integer id){
        Examination examination=examinationService.selectByPrimaryKey(id);
        TestExample example=new TestExample();
        example.createCriteria().andSubjectEqualTo(examination.getSubject());
        testService.deleteByExample(example);
        examinationService.deleteByPrimaryKey(id);
        ModelAndView modelAndView=new ModelAndView("redirect:examlist");
       return modelAndView;
    }
    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping(value = "/addStudent")
    public ModelAndView addStudent(Student student){
        ModelAndView modelAndView = new ModelAndView("redirect:Listofstudent");
        studentService.insert(student);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/ExistAjaxofstudent",produces = {"text/html;charset=UTF-8"})
    public String studentExistAjax(String studentnumber) throws UnsupportedEncodingException {
        URLDecoder.decode("studentnumber","UTF-8");
        StudentExample se = new StudentExample();
        se.createCriteria().andStunumberEqualTo(studentnumber);
        List<Student> student = studentService.selectByExample(se);
        if(student.size()>0 && studentnumber.equals(student.get(0).getStunumber())){
            return "该学号已存在";
        }else{
            return "恭喜您,该学号可添加";
        }
    }

    /**
     * 跳转到考试列表
     * @return
     */
    @RequestMapping(value = "/examlist")
    public ModelAndView examList(){
        ModelAndView modelAndView = new ModelAndView("admin/examList");
        ExaminationExample ee = new ExaminationExample();
        ee.createCriteria().andIdIsNotNull();
        List<Examination> exams = examinationService.selectByExample(ee);
        modelAndView.addObject("exams",exams);
        return modelAndView;
    }

    /**
     * 转到添加界面
     * @param id
     * @return
     */
//    考试科目信息显示有问题
    @RequestMapping(value = "/addStudentToExam")
    public ModelAndView addStudentToExam(Integer id){
        Examination examination=examinationService.selectByPrimaryKey(id);
        ModelAndView modelAndView = new ModelAndView("admin/addStudentToExam");
        modelAndView.addObject("exam",examination);
        return modelAndView;
    }

    /**
     * 为考试添加学生
     * @param
     * @return
     */
    @RequestMapping(value = "/addStudentToExamOperation")
    public ModelAndView addStudentToExamOperation(Integer id, String stunumber){
        ModelAndView modelAndView = new ModelAndView("admin/addStudentToExam");
        Examination examination=examinationService.selectByPrimaryKey(id);
        StudentExample example=new StudentExample();
        example.createCriteria().andStunumberEqualTo(stunumber);
        Student student=studentService.selectByExample(example).get(0);
        Test t = new Test();
        t.setSubject(examination.getSubject());
        t.setSdate(examination.getSdate());
        t.setEdate(examination.getEdate());
        t.setIsubmit(false);
        t.setPnumber(examination.getPn());
        t.setSnumber(examination.getSn());
        t.setStudent(student);
        t.setTestfk(student.getStuid());
        String score = new String("1=0");
        for (int i=1;i<t.getSnumber();i++)
        {
            score += ","+(i+1)+"=0";
        }
        t.setScores(score);
        String path = new String("images/upload/unload.JPG");
        for (int i=1;i<t.getSnumber();i++)
        {
            path += ";"+"images/upload/unload.JPG";
        }
        t.setPicturepaths(path);
        testService.insert(t);
        modelAndView.addObject("exam",examination);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/examStudentExistAjax",produces = {"text/html;charset=UTF-8"})
    public String examStudentExistAjax(String studentnumber, Integer id) throws UnsupportedEncodingException {
        //去数据库中查找是否已存在同名用户,如果存在同名用户则返回真实的user对象,如果不存在返回null
        URLDecoder.decode("studentnumber","UTF-8");
        Examination examination=examinationService.selectByPrimaryKey(id);
        StudentExample se = new StudentExample();
        se.createCriteria().andStunumberEqualTo(studentnumber);
        List<Student> students = studentService.selectByExample(se);
        if(students.size()>0){
            Student student = students.get(0);
            TestExample testExample = new TestExample();
            testExample.createCriteria().andTestfkEqualTo(student.getStuid()).andSubjectEqualTo(examination.getSubject());
            List<Test> t = testService.selectByExample(testExample);
            if (t.size()>0 && examination.getSubject().equals(t.get(0).getSubject())){
                return "该考试不可添加此学号的学生";
            }else{
                return "该学生可添加";
            }
        }else{
            return "该学号不存在";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/subjectExistAjax",produces = {"text/html;charset=UTF-8"})
    public String subjectExistAjax(String subject) throws UnsupportedEncodingException {
        URLDecoder.decode("subject","UTF-8");
        ExaminationExample ee = new ExaminationExample();
        ee.createCriteria().andSubjectEqualTo(subject);
        List<Examination> examination = examinationService.selectByExample(ee);
        if(examination.size()>0 && subject.equals(examination.get(0).getSubject())){
            return "该科目考试已存在";
        }else{
            return "恭喜您,该科目考试可添加";
        }
    }

    /**
     * 转到添加考试的页面
     * @return
     */
    @RequestMapping(value = "/toaddexam")
    public String toaddexam(){
        return "/admin/addExam";
    }

    /**
     * 执行添加考试的操作
     * @param subject
     * @param pn
     * @param sn
     * @param sdate
     * @param edate
     * @return
     */
    @RequestMapping(value = "/addExam")
    public ModelAndView addexam (String subject,Integer pn,Integer sn,Date sdate,Date edate){
        Examination examination=new Examination();
        examination.setSubject(subject);
        examination.setPn(pn);
        examination.setSn(sn);
        examination.setSdate(sdate);
        examination.setEdate(edate);
        examinationService.insert(examination);
        ModelAndView modelAndView=new ModelAndView("redirect:examlist");
        return modelAndView;
    }

    /**
     * 转到id为id的考试学生列表
     * @param id
     * @return
     */
    @RequestMapping(value = "tostuexamlist")
    public ModelAndView tostulist(Integer id)
    {
        Examination examination =examinationService.selectByPrimaryKey(id);
        TestExample example=new TestExample();
        example.createCriteria().andSubjectEqualTo(examination.getSubject());
        List<Test> tests=testService.selecByExampleWithStu(example);
        List<Test> first=new ArrayList<>();
        List<Test> last =new ArrayList<>();
        for(int i=0;i<tests.size();i++){
            Test test=tests.get(i);
            if(test.getIdread()==false){
                first.add(test);
            }
            else {
                last.add(test);
            }
        }
        first.addAll(last);
        ModelAndView modelAndView=new ModelAndView("admin/stuexamlist");
        modelAndView.addObject("exam",examination);
        modelAndView.addObject("tests",first);
        return modelAndView;
    }

    /**
     * 进入批阅界面
     * @param testid
     * @return
     */
    @RequestMapping(value = "read")
    public ModelAndView read(Integer testid){
        Test test=testService.selectByPrimaryKeyWithStu(testid);
        String[] paths=testService.getPaths(test);
        Integer[] scores=testService.getScores(test);
        ModelAndView modelAndView=new ModelAndView("admin/checkAnswer");
        modelAndView.addObject("test",test);
        modelAndView.addObject("paths",paths);
        modelAndView.addObject("scores",scores);
        return modelAndView;
    }

    /**
     * 更改第i题的分数
     * @param i
     * @param testid
     * @param score
     * @return
     */
    @RequestMapping(value = "updatescore")
    public ModelAndView updatescore(Integer i,Integer testid,Integer score){
        Test test=testService.selectByPrimaryKey(testid);
        testService.upadteIthScore(i,test,score);
        test=testService.selectByPrimaryKeyWithStu(testid);
        String[] paths=testService.getPaths(test);
        Integer[] scores=testService.getScores(test);

        return read(testid);
    }

    /**
     * 提交批阅结果
     * @param testid
     * @return
     */
    @RequestMapping(value = "submuitscore")
    public ModelAndView submit(Integer testid){
        ExaminationExample examinationExample=new ExaminationExample();
        Test test=testService.selectByPrimaryKey(testid);
        examinationExample.createCriteria().andSubjectEqualTo(test.getSubject());
        test.setIdread(true);
        testService.updateByPrimaryKey(test);
        return tostulist(examinationService.selectByExample(examinationExample).get(0).getId());
    }
}
