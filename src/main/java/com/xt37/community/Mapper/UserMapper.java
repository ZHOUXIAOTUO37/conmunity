package com.xt37.community.Mapper;

import com.xt37.community.Bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,password) values (#{username},#{password})")
    void insert(String username,String password);

    @Select("SELECT username,password FROM user WHERE username=#{username}AND password =#{password}")
    User findUserByNameAndPassword(String username, String password);


}
