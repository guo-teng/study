package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.PaymentMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService
{
    @Autowired
    private PaymentMapper paymentMapper;

    public String addpayment(Payment payment)
    {
        int x=paymentMapper.insertpayment(payment);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    public String deletepayment(int id)
    {
        int x=paymentMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String updatepayment(Payment payment)
    {
        int x=paymentMapper.updatebyid(payment);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public List<Payment> getbypaymentdate(String projectdate)
    {
        List<Payment> payments=paymentMapper.selectbydate(projectdate);
        return payments;
    }

    public List<Payment> getbyattention(String attention)
    {
        List<Payment> payments=paymentMapper.selectbyattention(attention);
        return payments;
    }

    public List<Payment> getall()
    {
        List<Payment> payments=paymentMapper.selectall();
        return payments;
    }

    //payment构造器
    public Payment paymentbuilder(int id,String paymentdate,float money,String attention,String more)
    {
        Payment payment=new Payment();
        payment.setId(id);
        payment.setPaymentdate(paymentdate);
        payment.setMoney(money);
        payment.setAttention(attention);
        payment.setMore(more);
        return payment;
    }

    //money筛选器
    public List<Payment> moneyselecter(List<Payment> payments,String mins,String maxs)
    {
        float temp;
        float max=Float.parseFloat(maxs);
        float min=Float.parseFloat(mins);
        for (int i=0;i<payments.size();i++)
        {
            temp=payments.get(i).getMoney();
            if (temp>max || temp<min)
            {
                payments.remove(i);
                i=i-1;
            }
        }
        return payments;
    }

    //时间筛选器
    public boolean timeselecter(String min,String max,String obj)
    {
        String[] mins=min.split("-");
        String[] maxs=max.split("-");
        String[] objs=obj.split("-");
        int[] weight=new int[3];
        weight[0]=360;
        weight[1]=30;
        weight[2]=1;
        int minint=0;
        int maxint=0;
        int objint=0;
        for (int i=0;i<3;i++)
        {
            minint=minint+Integer.parseInt(mins[i])*weight[i];
            maxint=maxint+Integer.parseInt(maxs[i])*weight[i];
            objint=objint+Integer.parseInt(objs[i])*weight[i];
        }
        if(objint>=minint && objint<=maxint)
            return true;
        else
            return false;
    }

    //date筛选器
    public List<Payment> dateselecter(List<Payment> payments,String starttime,String endtime)
    {
        String temp;
        for (int i=0;i<payments.size();i++)
        {
            temp=payments.get(i).getPaymentdate();
            if (!timeselecter(starttime,endtime,temp))
            {
                payments.remove(i);
                i=i-1;
            }
        }
        return payments;
    }

    //money合理性检查器
    public boolean checkmoney(String min,String max)
    {
        if (Float.parseFloat(min)>Float.parseFloat(max))
            return false;
        else
            return true;
    }

    //time合理性检查器
    public boolean checktime(String starttime,String endtime)
    {
        String[] min=starttime.split("-");
        String[] max=endtime.split("-");
        int[] weight=new int[3];
        weight[0]=365;
        weight[1]=30;
        weight[2]=1;
        int minint=0;
        int maxint=0;
        for (int i=0;i<3;i++)
        {
            minint=minint+Integer.parseInt(min[i])*weight[i];
            maxint=maxint+Integer.parseInt(max[i])*weight[i];
        }
        if(minint<=maxint)
            return true;
        else
            return false;

    }

}
