package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.ProjectSpend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectSpendMapper
{
    int insertprojectspend(ProjectSpend projectSpend);

    int deletebyid(int id);

    int updatebyid(ProjectSpend projectSpend);

    List<ProjectSpend> selectbyprojectname(String projectname);

    List<ProjectSpend> selectbymoney(float money);

    List<ProjectSpend> selectall();

}
