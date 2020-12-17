package com.xt37.community.controller;

import com.xt37.community.Bean.User;
import com.xt37.community.Mapper.UserMapper;
import com.xt37.community.Service.registService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class registController {


    @Autowired
    private UserMapper userMapper;

    @PostMapping("/regist")
    public String regist(HttpServletRequest request, HttpServletResponse response) {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            userMapper.insert(username, password);

            response.sendRedirect("login");


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
