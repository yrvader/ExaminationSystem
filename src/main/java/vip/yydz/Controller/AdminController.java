package vip.yydz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vip.yydz.domain.*;
import vip.yydz.service.ExaminationService;
import vip.yydz.service.StudentService;
import vip.yydz.service.TestService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

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
    @RequestMapping(value = "/toAdmin")
    public String toAdmin(){
        return "admin/adminLogin";
    }

    @RequestMapping(value = "/studentList")
    public ModelAndView studentList(){
        ModelAndView modelAndView = new ModelAndView("admin/studentList");
        StudentExample se = new StudentExample();
        se.createCriteria().andStuidIsNotNull();
        List<Student> students = studentService.selectByExample(se);
        modelAndView.addObject("students",students);
        return modelAndView;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Integer stuid){
        ModelAndView modelAndView = new ModelAndView("redirect:studentList");
        studentService.deleteByPrimaryKey(stuid);
        return modelAndView;
    }

    @RequestMapping(value = "/addStudent")
    public ModelAndView addStudent(Student student){
        ModelAndView modelAndView = new ModelAndView("redirect:studentList");
        studentService.insert(student);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/studentExistAjax",produces = {"text/html;charset=UTF-8"})
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

    @RequestMapping(value = "/examlist")
    public ModelAndView examList(){
        ModelAndView modelAndView = new ModelAndView("admin/examlist");
        ExaminationExample ee = new ExaminationExample();
        ee.createCriteria().andIdIsNotNull();
        List<Examination> exams = examinationService.selectByExample(ee);
        modelAndView.addObject("exams",exams);
        return modelAndView;
    }

//    考试科目信息显示有问题
    @RequestMapping(value = "/addStudentToExam")
    public ModelAndView addStudentToExam(Examination examination){
        ModelAndView modelAndView = new ModelAndView("admin/addStudentToExam");
        modelAndView.addObject("exam",examination);
        return modelAndView;
    }

    @RequestMapping(value = "/addStudentToExamOperation")
    public ModelAndView addStudentToExamOperation(Examination examination, Student student){
        ModelAndView modelAndView = new ModelAndView("admin/addStudentToExam");
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
        String path = new String("1");
        for (int i=1;i<t.getSnumber();i++)
        {
            path += ";"+(i+1);
        }
        t.setPicturepaths(path);
        testService.insert(t);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/examStudentExistAjax",produces = {"text/html;charset=UTF-8"})
    public String examStudentExistAjax(String studentnumber, Examination examination) throws UnsupportedEncodingException {
        //去数据库中查找是否已存在同名用户,如果存在同名用户则返回真实的user对象,如果不存在返回null
        URLDecoder.decode("studentnumber","UTF-8");
        StudentExample se = new StudentExample();
        se.createCriteria().andStunumberEqualTo(studentnumber);
        List<Student> students = studentService.selectByExample(se);
        if(students.size()>0){
            Student student = students.get(0);
            TestExample testExample = new TestExample();
            testExample.createCriteria().andTestfkEqualTo(student.getStuid()).andSubjectEqualTo(examination.getSubject());
            List<Test> t = testService.selectByExample(testExample);
            if (t.size()>0 && examination.getSubject().equals(t.get(0).getSubject())){
                return "该学生可添加";
            }else{
                return "该考试不可添加此学号的学生";
            }
        }else{
            return "该学号不存在";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //退出登录的本质就是对session数据的销毁
        session.invalidate();
        return "redirect:index";
    }

}
