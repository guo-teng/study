package com.bupt317.study.lab_manager;

import com.bupt317.study.lab_manager.mapper.ProjectMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabManagerApplicationTests {

    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void projectselecttest()
    {
        System.out.println("success");
        List<Project> projects=projectMapper.selectall();
        System.out.println("the xxx is"+projects.size());
    }
}
