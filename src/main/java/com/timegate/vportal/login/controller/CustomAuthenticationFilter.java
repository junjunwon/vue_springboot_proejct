package com.timegate.vportal.login.controller;

import com.timegate.vportal.common.utils.MessageLogger;
import com.timegate.vportal.common.utils.RSAUtils;
import com.timegate.vportal.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    MessageLogger logger = new MessageLogger();

    @Autowired
    private UserService userService;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.debugLog(new Object(){}, "CustomAuthenticationFilter!!!!!!!!!!!!!!!!");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.debugLog(new Object(){}, "username:" + username);
        logger.debugLog(new Object(){}, "password:" + password);
        logger.debugLog(new Object(){}, RSAUtils.PRIVATE_KEY + ":" + (PrivateKey) request.getSession().getAttribute(RSAUtils.PRIVATE_KEY));
        String decryptUsername = null;
        String decryptPassword = null;
        try {
            decryptUsername = RSAUtils.decryptRSA(username, (PrivateKey) request.getSession().getAttribute(RSAUtils.PRIVATE_KEY));
            decryptPassword = RSAUtils.decryptRSA(password, (PrivateKey) request.getSession().getAttribute(RSAUtils.PRIVATE_KEY));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.debugLog(new Object(){}, "decryptUsername:" +decryptUsername);
        logger.debugLog(new Object(){}, "decryptPassword:" +decryptPassword);

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(decryptUsername, decryptPassword);
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
