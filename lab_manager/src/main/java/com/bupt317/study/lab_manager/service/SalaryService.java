package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.SalaryMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService
{
    @Autowired
    private SalaryMapper salaryMapper;

    public String addsalary(Salary salary)
    {
        int x=salaryMapper.insertsalary(salary);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String deletesalary(int id)
    {
        int x=salaryMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String updatesalary(Salary salary)
    {
        int x=salaryMapper.updatebyid(salary);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    public List<Salary> getbystudentid(String studentid)
    {
        List<Salary> salaries=salaryMapper.selectbystudentid(studentid);
        return salaries;
    }

    public List<Salary> getbyname(String name)
    {
        List<Salary> salaries=salaryMapper.selectbyname(name);
        return salaries;
    }

    public List<Salary> getall()
    {
        List<Salary> salaries=salaryMapper.selectall();
        return salaries;
    }

}
