package com.xt37.community.controller;

import com.xt37.community.Bean.Result;
import com.xt37.community.Bean.User;
import com.xt37.community.Mapper.UserMapper;
import com.xt37.community.Service.LoginService;
import com.xt37.community.util.PageAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class validate {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "login")
    public String validate(User user, HttpServletRequest request, HttpServletResponse response) {
        boolean b;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);

        boolean find = loginService.Find(username, password);
        if (find = true) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("user_cookie", user.getUsername());
            response.addCookie(cookie);
            try {
                response.sendRedirect("index");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
