package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.NoticeMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService
{
    @Autowired
    private NoticeMapper noticeMapper;

    //增加说明
    public String addnotice(Notice notice)
    {
        int x=noticeMapper.insertnotice(notice);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    //根据type来删除说明
    public String deletenotice(String type)
    {
        int x=noticeMapper.deletebyid(type);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //根据类型来查询用户列表
    public List<Notice> getbytype(String type)
    {
        List<Notice> notices=noticeMapper.selectbytype(type);
        return notices;
    }

    //根据类型查询说明
    public Notice selectonebytype(String type)
    {
        Notice notice=noticeMapper.selectonebytype(type);
        return notice;
    }

    //根据id来查询用户
    public Notice getbyid(int id)
    {
        Notice notice=noticeMapper.selectbyid(id);
        return notice;
    }

    //构建pojo
    public Notice noticebuilder(String type,String noticedate,String content)
    {
        Notice notice=new Notice();
        notice.setId(0);
        notice.setType(type);
        notice.setNoticedate(noticedate);
        notice.setContent(content);
        return notice;
    }

}
