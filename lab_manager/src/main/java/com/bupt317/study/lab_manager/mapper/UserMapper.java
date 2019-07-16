package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//将mapper对象声明为托管对象
public interface UserMapper
{
    //根据用户名查询
    User selectbyusername(String username);

    //根据id查询用户
    User selectbyid(int id);

    //插入用户
    int insertuser(User user);

    //根据id删除用户
    int deletebyid(int id);

    //根据id更新用户权限和密码
    int updatebyid(User user);

    //查询所有用户
    List<User> selectall();

}
