package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.Gain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GainMapper
{
    int insertgain(Gain gain);

    int deletebyid(int id);

    int updatebyid(Gain gain);

    Gain selectbyid(int id);

    List<Gain> selectbydate(String gaindate);

    List<Gain> selectbymoney(float money);

    List<Gain> selectall();
}
