package com.xt37.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
