package com.timegate.vportal.login.controller;

import com.timegate.vportal.common.utils.MessageLogger;
import com.timegate.vportal.login.domain.UserDto;
import com.timegate.vportal.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    MessageLogger logger = new MessageLogger();

    @PostMapping("/api/auth/registUser")
    public String registUser(UserDto userDto) {
        logger.infoLog(new Object(){}, userDto.getEmail());
        userService.save(userDto);
        //return "redirect:/login";
        return "/login";
    }
}
