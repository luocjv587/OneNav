package com.example.navigation.handler;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * ProjectName: navigation
 * PackageName: com.example.navigation.handler
 * <p>
 * DateTime: 2021-11-25 4:45 下午
 *
 * @author luocj
 */

@ControllerAdvice
public class IMoocExceptionHandler {

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @ExceptionHandler(value = Exception.class)
    public Object unknownErrorHandler(HttpServletRequest reqest,
                                      HttpServletResponse response, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", reqest.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

}
