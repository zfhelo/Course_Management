package org.gdpi.course.utils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandleExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        String msg;
        if (e instanceof ExceptionMessage) {
            msg = ((ExceptionMessage) e).getMsg();
        } else {
            msg = "请稍后再试";
        }
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("include/error");
        return modelAndView;
    }
}
