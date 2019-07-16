package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.BillMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService
{
    @Autowired
    private BillMapper billMapper;

    public String addbill(Bill bill)
    {
        int x=billMapper.insertbill(bill);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String deletebill(int id)
    {
        int x=billMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String updatebill(Bill bill)
    {
        int x=billMapper.updatebyid(bill);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //根据id更新state
    public String updatebillbyid(Bill bill)
    {
        int x=billMapper.updatestatebyid(bill);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    //根据username查询
    public List<Bill> getbyname(String name)
    {
        List<Bill> bills=billMapper.selectbyname(name);
        return bills;
    }

    //根据state查询
    public List<Bill> getbystate(String state)
    {
        List<Bill> bills=billMapper.selectbystate(state);
        return bills;
    }

    public List<Bill> getbystudentid(String studentid)
    {
        List<Bill> bills=billMapper.selectbystudentid(studentid);
        return bills;
    }

    public List<Bill> getall()
    {
        List<Bill> bills=billMapper.selectall();
        return bills;
    }

    public Bill billbuilder(int id,String state)
    {
        Bill bill=new Bill();
        bill.setId(id);
        bill.setState(state);
        return bill;
    }

    public Bill billsbuilder(int id,String name,float money,String billtime,String billtype,String billpattern,String studentid,String invoice,String buyer,String seller,String paymentways,String billcontent,String state)
    {
        Bill bill=new Bill();
        bill.setId(id);
        bill.setName(name);
        bill.setMoney(money);
        bill.setBilltime(billtime);
        bill.setBilltype(billtype);
        bill.setState(state);
        bill.setBuyer(buyer);
        bill.setSeller(seller);
        bill.setBillpattern(billpattern);
        bill.setBillcontent(billcontent);
        bill.setStudentid(studentid);
        bill.setInvoice(invoice);
        bill.setPaymentways(paymentways);
        return bill;
    }
}
