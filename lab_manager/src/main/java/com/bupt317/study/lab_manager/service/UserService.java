package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.UserMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//表明这是一个service
@Service
public class UserService
{
    @Autowired
    //自动注入mapper
    private UserMapper userMapper;

    //登陆验证
    //用户名和密码不对返回n，若正确返回权限值
    public String login(String username,String password)
    {
        //User user=new User();
        User user=userMapper.selectbyusername(username);
        if (user==null)
            return "N";
        else if (user.getPassword().equals(password))
            {
                return user.getAuthority();
            }
        else
            return "N";
    }

    //添加用户，成功返回y，否则返回n
    public String adduser(User user)
    {
        int x=userMapper.insertuser(user);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //根据id删除用户，成功返回y，否则返回n
    public String deleteuser(int id)
    {
        int x=userMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //根据id更新用户,成功返回y，失败返回n
    public String updateuser(User user)
    {
        int x=userMapper.updatebyid(user);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    //根据用户名查询所有用户
    public User getbyusername(String username)
    {
        User user=userMapper.selectbyusername(username);
        return user;
    }

    //根据id查询用户
    public User getbyid(int id)
    {
        User user=userMapper.selectbyid(id);
        return user;
    }

    //查询所有用户
    public List<User> getalluser()
    {
        List<User> users=userMapper.selectall();
        return users;
    }

    //创建user对象
    public User userbuilder(int id,String authority,String username,String password)
    {
        User user=new User();
        user.setId(id);
        user.setAuthority(authority);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    //检查用户名是否重合
    public String checkusername(String username)
    {
        User user=userMapper.selectbyusername(username);
        if (user==null)
            return "Y";
        else
            return "N";
    }

}
