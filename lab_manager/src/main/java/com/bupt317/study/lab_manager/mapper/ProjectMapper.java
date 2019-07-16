package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper
{
    int insertproject(Project project);

    int deletebyid(int id);

    int updatebyid(Project project);

    Project selectbyprojectname(String projectname);

    Project selectbyid(int id);

    List<Project> selectbyprojectstate(String projectstate);

    List<Project> selectall();

}
