package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.GainMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Gain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GainService
{
    @Autowired
    private GainMapper gainMapper;

    public String addgain(Gain gain)
    {
        int x=gainMapper.insertgain(gain);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    public String deletegain(int id)
    {
        int x=gainMapper.deletebyid(id);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    public String updategain(Gain gain)
    {
        int x=gainMapper.updatebyid(gain);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    public Gain getbyid(int id)
    {
        Gain gain=gainMapper.selectbyid(id);
        return gain;
    }

    public List<Gain> getbydate(String gaindate)
    {
        List<Gain> gains=gainMapper.selectbydate(gaindate);
        return gains;
    }

    public List<Gain> getbymoney(float money)
    {
        List<Gain> gains=gainMapper.selectbymoney(money);
        return gains;
    }

    public List<Gain> getall()
    {
        List<Gain> gains=gainMapper.selectall();
        return gains;
    }

    public Gain gainbuilder(int id,String gaindate,float money,String more,String attention)
    {
        Gain gain=new Gain();
        gain.setId(id);
        gain.setAttention(attention);
        gain.setGaindate(gaindate);
        gain.setMoney(money);
        gain.setMore(more);
        return gain;
    }
}
