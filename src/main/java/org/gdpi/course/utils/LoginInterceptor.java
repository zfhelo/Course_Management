package org.gdpi.course.utils;

import org.gdpi.course.pojo.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        Object tea = session.getAttribute("TEACHER");
        Object stu = session.getAttribute("STUDENT");
        // 用户未登录
        if (stu == null && tea == null) {
            // 跳转登录界面
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }
        return true;
    }

}
