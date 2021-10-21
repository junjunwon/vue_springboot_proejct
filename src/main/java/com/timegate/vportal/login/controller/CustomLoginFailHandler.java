package com.timegate.vportal.login.controller;

import com.timegate.vportal.common.utils.MessageLogger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginFailHandler implements AuthenticationFailureHandler {

    MessageLogger logger = new MessageLogger();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.debugLog(new Object(){}, "CustomLoginFailHandler!!!!!!!!!!!!!!!!");

        response.setStatus(401);
    }
}
