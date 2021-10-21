package com.timegate.vportal.login.controller;

import com.timegate.vportal.common.utils.MessageLogger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    MessageLogger logger = new MessageLogger();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        logger.debugLog(new Object(){}, "CustomLoginSuccessHandler!!!!!!!!!!!!!!!!");

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.debugLog(new Object(){}, "username:" + username);
        logger.debugLog(new Object(){}, "password:" + password);
        logger.debugLog(new Object(){}, "auth.name:" + authentication.getName());

        response.setStatus(200);
        //response.setHeader("authentication",  authentication.getName());
        response.setHeader("authorization",  authentication.getName());
        //response.sendRedirect("/dashboard");
    }
}
