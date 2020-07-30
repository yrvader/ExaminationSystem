package vip.yydz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import vip.yydz.domain.Student;
import vip.yydz.domain.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 实现登录验证的拦截功能    实现 Interceptor接口
 * */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //开启登录验证
        //首先应该获取当前的地址
        String uri = request.getRequestURI();
        //如果用户访问的地址是无需验证的页面,则放行
        if(uri.indexOf("/login") >= 0){
            return true;//放行
        }
        if(uri.indexOf("index") >= 0){
            return true;//放行
        }
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("stu");
        if(student!=null){
            if (uri.indexOf("/admin")>=0) {
                request.setAttribute("msg","亲,请先登录");
                request.getRequestDispatcher("/admin/login").forward(request,response);
                return false;
            }
            else if(uri.indexOf("/uploadExam")>=0||uri.indexOf("/submit")>=0){
                session = request.getSession();
                Test examination = (Test) session.getAttribute("test");
                Date myDate=new Date();
                if (examination!=null&&examination.getEdate().before(myDate))
                {
                    request.setAttribute("msg","考试已结束");
                    request.getRequestDispatcher("/stu/stu").forward(request,response);
                    return false;
                }
                else {
                    return  true;
                }
            }
            else {
                return true;
            }
        }
        Object admin = session.getAttribute("admin");
        if (admin!=null){
            if (uri.indexOf("/stu")>=0) {
                request.setAttribute("msg","亲,请先登录");
                request.getRequestDispatcher("/stu/login").forward(request,response);
                return false;
            }
            else {
                return true;
            }
        }
        request.getRequestDispatcher("/stu/login").forward(request,response);
        request.setAttribute("msg","亲,请先登录");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
