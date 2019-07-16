package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryMapper
{
    int insertsalary(Salary salary);

    int deletebyid(int id);

    int updatebyid(Salary salary);

    List<Salary> selectbystudentid(String studentid);

    List<Salary> selectbyname(String name);

    List<Salary> selectall();
}
