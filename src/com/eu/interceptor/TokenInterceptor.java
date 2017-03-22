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

        // Access Token 有效即跳转
        if (userSecurityService.checkAccessToken(uid,accesstoken)){

            return true;
        }

        // Access Token 无效输出错误消息
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write("[{\"status\":400,\"data\":\"身份消息已过期，请重新登陆\"}]");

        return false;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
