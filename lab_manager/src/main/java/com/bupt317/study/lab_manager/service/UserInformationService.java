package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.UserInformationMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationService
{
    @Autowired
    private UserInformationMapper userInformationMapper;

    //随user增加而增加
    public String addwithuser(String username,String name,String studentid)
    {
        UserInformation userInformation=new UserInformation();
        userInformation.setUsername(username);
        userInformation.setName(name);
        userInformation.setStudentid(studentid);
        int x=userInformationMapper.insertuserinformation(userInformation);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //随user删除而删除
    public String deletewithuser(String username)
    {
        int x=userInformationMapper.deletebyusername(username);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //更新用户信息
    public String updateuserinformation(UserInformation userInformation)
    {
        int x=userInformationMapper.updatebyid(userInformation);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //根据用户名查询
    public UserInformation getbyusername(String username)
    {
        UserInformation userInformation=userInformationMapper.selectbyusername(username);
        return userInformation;
    }

    //查询所有用户信息
    public List<UserInformation> getall()
    {
        List<UserInformation> userInformations=userInformationMapper.selectall();
        return userInformations;
    }

    //根据id查询
    public UserInformation getbyid(int id)
    {
        UserInformation userInformation=userInformationMapper.selectbyid(id);
        return userInformation;
    }

    //构建pojo
    public UserInformation userinfobuilder(int id,String name,String studentid,String idcard,String birthday)
    {
        UserInformation userInformation=new UserInformation();
        userInformation.setName(name);
        userInformation.setStudentid(studentid);
        userInformation.setIdcard(idcard);
        userInformation.setBirthday(birthday);
        userInformation.setId(id);
        userInformation.setUsername("unkonwn");
        return userInformation;
    }

}
