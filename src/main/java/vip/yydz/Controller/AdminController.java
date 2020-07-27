package vip.yydz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.yydz.domain.Student;
import vip.yydz.domain.Test;
import vip.yydz.service.StudentService;
import vip.yydz.service.TestService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    static private String username="admin";
    static private String password="123456";
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @RequestMapping(value = "/toAdmin")
    public String toAdmin(){
        return "admin/admin";
    }

}
