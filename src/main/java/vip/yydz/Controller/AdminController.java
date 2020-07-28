package vip.yydz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vip.yydz.domain.Student;
import vip.yydz.domain.StudentExample;
import vip.yydz.domain.Test;
import vip.yydz.service.StudentService;
import vip.yydz.service.TestService;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "/loginCheck")
    public ModelAndView loginCheck(Student student,Boolean isad, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(student);
        if(!isad){
            StudentExample studentExample=new StudentExample();
            studentExample.createCriteria().andPasswordEqualTo(student.getPassword());
            studentExample.createCriteria().andStunumberEqualTo(student.getStunumber());
            List<Student> students=studentService.selectByExampleWithTest(studentExample);
            if(!students.isEmpty()){
                modelAndView.setViewName("/stu/stu");//重定向管理首页
                session.setAttribute("stu",students.get(0));//封装学生
                //model目的就是把数据封装在  request对象里传递,
            }else{//不存在
                modelAndView.setViewName("login");//返回登录页
            }
        }
        else {
            if (username.equals(student.getStunumber())&&password.equals(student.getPassword())){
                modelAndView.setViewName("/admin/admin");
            }
            else {
                modelAndView.setViewName("login");//返回登录页
            }
        }
        return modelAndView;
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
