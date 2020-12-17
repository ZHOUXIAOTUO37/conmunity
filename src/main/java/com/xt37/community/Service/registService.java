package com.xt37.community.Service;

import com.xt37.community.Bean.User;
import com.xt37.community.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class registService {

    @Autowired
    private UserMapper userMapper;
    public String regist(String username,String password){
        //User insert = userMapper.insert(username, password);

        return "success";
    }
}
in