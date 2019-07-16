package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper
{
    int insertnotice(Notice notice);

    int deletebyid(String type);

    Notice selectbyid(int id);

    List<Notice> selectbytype(String type);

    Notice selectonebytype(String type);
}
