package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.ProjectSpendMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.ProjectSpend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectSpendService
{
    @Autowired
    private ProjectSpendMapper projectSpendMapper;

    //创建pojo
    public ProjectSpend projectspendbuilder(String projectname,float money,String spenddate,String attention)
    {
        ProjectSpend projectSpend=new ProjectSpend();
        projectSpend.setId(0);
        projectSpend.setProjectname(projectname);
        projectSpend.setMoney(money);
        projectSpend.setSpenddate(spenddate);
        projectSpend.setAttention(attention);
        return projectSpend;
    }

    public String addprojectspend(ProjectSpend projectSpend)
    {
        int x=projectSpendMapper.insertprojectspend(projectSpend);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String deleteprojectspend(int id)
    {
        int x=projectSpendMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String updateprojectspend(ProjectSpend projectSpend)
    {
        int x=projectSpendMapper.updatebyid(projectSpend);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public List<ProjectSpend> getbyprojectname(String projectname)
    {
        List<ProjectSpend> projectSpends=projectSpendMapper.selectbyprojectname(projectname);
        return projectSpends;
    }

    public List<ProjectSpend> getbymoney(float money)
    {
        List<ProjectSpend> projectSpends=projectSpendMapper.selectbymoney(money);
        return projectSpends;
    }

    public List<ProjectSpend> getall()
    {
        List<ProjectSpend> projectSpends=projectSpendMapper.selectall();
        return projectSpends;
    }

}
