package com.xt37.community.Mapper;


import com.xt37.community.Bean.githubUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/*
 * 数据库
 * */
@Mapper
public interface UserMappers {
    @Insert("insert into githubUser(name,account_id,token,gmt_creat,gmtModified) values (#{name},${accountId},#{token},#{gmtCreat},#{gmt_modified});")
    void insert(githubUser githubUser) ;

}
