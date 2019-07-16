package com.bupt317.study.lab_manager.controller;

import com.bupt317.study.lab_manager.pojo.mybatis.Gain;
import com.bupt317.study.lab_manager.pojo.mybatis.Payment;
import com.bupt317.study.lab_manager.service.GainService;
import com.bupt317.study.lab_manager.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThirdProjectController
{
    @Autowired
    PaymentService paymentService;
    @Autowired
    GainService gainService;

    //出账一览页面跳转
    @RequestMapping(value = "/fourthpage/payment")
    public String topayment()
    {
        return "/fourthpage/payment";
    }

    //入账页面跳转
    @RequestMapping(value = "/fourthpage/gain")
    public String togain()
    {
        return "/fourthpage/gain";
    }

    //新建入账页面跳转
    @RequestMapping(value = "/fourthpage/create_gain")
    public String tocreategain()
    {
        return "/fourthpage/create_gain";
    }

    //修改入账页面跳转
    @RequestMapping(value = "/fourthpage/alter_gain")
    public String toaltergain()
    {
        return "/fourthpage/alter_gain";
    }

    //修改出账页面
    @RequestMapping(value = "/fourthpage/paymentedit")
    public String topaymentedit()
    {
        return "/fourthpage/paymentedit";
    }

    //查询全部出账数据
    @RequestMapping(value = "/get_allpayment",method = RequestMethod.POST)
    @ResponseBody
    public List<Payment> getallpayment()
    {
        List<Payment> payments=new ArrayList<Payment>();
        payments=paymentService.getall();
        return payments;
    }

    //根据条件查询数据
    @RequestMapping(value = "/payment_search",method = RequestMethod.POST)
    @ResponseBody
    public List<Payment> getbysearch(String attention,String money_min,String money_max,String starttime,String endtime)
    {
        List<Payment> payments=new ArrayList<Payment>();
        boolean flag1=paymentService.checkmoney(money_min,money_max);
        boolean flag2=paymentService.checktime(starttime,endtime);
        if (flag1 && flag2)
        {
            payments=paymentService.getbyattention(attention);
            payments=paymentService.moneyselecter(payments,money_min,money_max);
            payments=paymentService.dateselecter(payments,starttime,endtime);
            return payments;
        }
        else
            return payments;
    }

    //更新payment
    @RequestMapping(value = "/payment_edit",method = RequestMethod.POST)
    @ResponseBody
    public String alterpayment(String id,String paymentdate,String money,String attention,String more)
    {
        Payment payment=paymentService.paymentbuilder(Integer.parseInt(id),paymentdate,Float.parseFloat(money),attention,more);
        String site=paymentService.updatepayment(payment);
        return site;
    }

    //获取全部gain
    @RequestMapping(value = "/get_allgain",method = RequestMethod.POST)
    @ResponseBody
    public List<Gain> getallgain()
    {
        List<Gain> gains=new ArrayList<Gain>();
        gains=gainService.getall();
        return gains;
    }

    //根据条件查询gain

    //更新gain
    @RequestMapping(value = "/gain_edit",method = RequestMethod.POST)
    @ResponseBody
    public String updategain(String id,String gaindate,String money,String attention,String more)
    {
        Gain gain=gainService.gainbuilder(Integer.parseInt(id),gaindate,Float.parseFloat(money),more,attention);
        String site=gainService.updategain(gain);
        return site;
    }

    //入账删除
    @RequestMapping(value = "/deletegain",method = RequestMethod.POST)
    @ResponseBody
    public String removegain(String id)
    {
        String site=gainService.deletegain(Integer.parseInt(id));
        return site;
    }

    //新建入账
    @RequestMapping(value = "/gain_create",method = RequestMethod.POST)
    @ResponseBody
    public String creategain(String gaindate,String money,String attention,String more)
    {
        Gain gain=gainService.gainbuilder(0,gaindate,Float.parseFloat(money),more,attention);
        String site=gainService.addgain(gain);
        return site;
    }


}
