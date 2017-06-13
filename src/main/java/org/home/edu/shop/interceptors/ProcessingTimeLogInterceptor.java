package org.home.edu.shop.interceptors;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SweetHome on 11.06.2017.
 */
@Log4j
public class ProcessingTimeLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        log.info("Pre handle to: " + request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String query = request.getQueryString() == null ? "" : "?" + request.getQueryString();
        String path = request.getRequestURL() + query;
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        log.info(String.format("%s millisecond taken to process the request %s.", (endTime - startTime), path));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //NOP
    }
}
