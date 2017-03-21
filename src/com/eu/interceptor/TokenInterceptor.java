package com.eu.interceptor;


/**
 * Created by lip on 17/3/21.
 */
public class TokenInterceptor implements org.springframework.web.servlet.HandlerInterceptor {


    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("-----preHandle------");
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {

        System.out.println("-----postHandle------");
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("-----afterCompletion------");
    }
}
