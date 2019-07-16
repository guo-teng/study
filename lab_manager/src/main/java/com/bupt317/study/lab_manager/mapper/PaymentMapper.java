package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMapper
{
    int insertpayment(Payment payment);

    int deletebyid(int id);

    int updatebyid(Payment payment);

    List<Payment> selectbydate(String paymentdate);

    //List<Payment> selectbymoney(int money);

    List<Payment> selectbyattention(String attention);

    List<Payment> selectall();

}
