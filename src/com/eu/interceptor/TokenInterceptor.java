package com.eu.interceptor;


import com.eu.service.UserSecurityService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lip on 17/3/21.
 */
public class TokenInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

    @Autowired
    private UserSecurityService userSecurityService;

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o) throws Exception {

        String accesstoken = httpServletRequest.getParameter("accesstoken");
        String uid = httpServletRequest.getParameter("uid");
        if (userSecurityService.checkAccessToken(uid,accesstoken)){

            return true;
        }
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write("[{\"data\":\"AccessToken无效\"}]");

        return false;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
