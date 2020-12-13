package com.xt37.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
    @GetMapping("/login")
    public String login(@RequestParam(name = "name") String name,
                        @RequestParam(name = "password") String password) {
        if (name =="admin" && password == "111111"){
            return "index";
        }
        else {
            return "login";
        }
    }
}
