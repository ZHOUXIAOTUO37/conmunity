package com.xt37.community.Service;

import com.xt37.community.Bean.Result;
import com.xt37.community.Bean.User;
import com.xt37.community.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    //与mapper进行交互
    private UserMapper userMapper;

    public boolean Find(String username, String password) {
        User userByNameAndPassword = userMapper.findUserByNameAndPassword(username, password);

        if (userByNameAndPassword != null) {
            return true;
        } else {
            return false;
        }

    }


}

