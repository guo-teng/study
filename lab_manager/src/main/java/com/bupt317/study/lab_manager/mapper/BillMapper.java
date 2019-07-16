package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper
{
    int insertbill(Bill bill);

    int deletebyid(int id);

    int updatebyid(Bill bill);

    int updatestatebyid(Bill bill);

    List<Bill> selectbyname(String name);

    List<Bill> selectbystudentid(String studentid);

    List<Bill> selectall();

    List<Bill> selectbystate(String state);

}
