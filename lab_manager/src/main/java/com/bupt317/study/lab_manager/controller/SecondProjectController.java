package com.bupt317.study.lab_manager.controller;

import com.bupt317.study.lab_manager.pojo.mybatis.Bill;
import com.bupt317.study.lab_manager.pojo.mybatis.Notice;
import com.bupt317.study.lab_manager.pojo.mybatis.User;
import com.bupt317.study.lab_manager.pojo.mybatis.UserInformation;
import com.bupt317.study.lab_manager.service.BillService;
import com.bupt317.study.lab_manager.service.NoticeService;
import com.bupt317.study.lab_manager.service.UserInformationService;
import com.bupt317.study.lab_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SecondProjectController
{
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    UserService userService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    BillService billService;

    //修改用户信息界面跳转
    @RequestMapping(value = "/thirdpage/alteruser")
    public String toalteruser()
    {
        return "/thirdpage/alteruser";
    }

    //修改个人界面跳转
    @RequestMapping(value = "/thirdpage/alterowninfo")
    public String toalterowninfo()
    {
        return "/thirdpage/alterowninfo";
    }

    //修改权限界面跳转
    @RequestMapping(value = "/authmanager")
    public String toauthmanager()
    {
        return "/authmanager";
    }

    //报销审核页面跳转
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/thirdpage/checkbill")
    public String tocheckbill()
    {
        return "/thirdpage/checkbill";
    }

    //报销页面跳转
    @RequestMapping(value = "/thirdpage/bill")
    public String tobill(Model model)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user=userService.getbyusername(username);
        model.addAttribute("userauth",user.getAuthority());
        return "/thirdpage/bill";
    }

    //新建报销页面跳转
    @RequestMapping(value = "/thirdpage/newbill")
    public String tonewbill()
    {
        return "/thirdpage/newbill";
    }

    //个人资料界面跳转
    @RequestMapping(value = "/thirdpage/owninformation")
    public String toowninformation(Model model)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        UserInformation userInformation=userInformationService.getbyusername(username);
        model.addAttribute("name",userInformation.getName());
        model.addAttribute("studentid",userInformation.getStudentid());
        model.addAttribute("idcard",userInformation.getIdcard());
        model.addAttribute("birthday",userInformation.getBirthday());
        return "/thirdpage/owninformation";
    }

    //修改说明界面跳转
    @RequestMapping(value = "/thirdpage/altersysnotice")
    public String toaltersysnotice()
    {
        return "/thirdpage/altersysnotice";
    }

    //系统使用说明界面跳转，model传值
    @RequestMapping(value = "/thirdpage/sysdescription")
    public String tosysdescription(Model model)
    {
        Notice notice1=noticeService.selectonebytype("P");
        Notice notice2=noticeService.selectonebytype("B");
        Notice notice3=noticeService.selectonebytype("S");
        Notice notice4=noticeService.selectonebytype("U");
        model.addAttribute("projectnotice",notice1.getContent());
        model.addAttribute("billnotice",notice2.getContent());
        model.addAttribute("salarynotice",notice3.getContent());
        model.addAttribute("usernotice",notice4.getContent());
        return "/thirdpage/sysdescription";
    }

    //查询所有用户信息
    @RequestMapping(value = "/userinformation",method = RequestMethod.POST)
    @ResponseBody
    public List<UserInformation> getuserinfo()
    {
        List<UserInformation> userInformations=new ArrayList<UserInformation>();
        userInformations=userInformationService.getall();
        return userInformations;
    }

    //根据id查询用户信息
    @RequestMapping(value = "/getuserinfo_byid",method = RequestMethod.POST)
    @ResponseBody
    public UserInformation getuserinfobyid(int id)
    {
        UserInformation userInformation=userInformationService.getbyid(id);
        return userInformation;
    }

    //更新用户信息
    @RequestMapping(value = "/userinfo_alter",method = RequestMethod.POST)
    @ResponseBody
    public String updateuserinfo(String id,String name,String studentid,String idcard,String birthday)
    {
        int intid=Integer.parseInt(id);
        UserInformation userInformation=userInformationService.userinfobuilder(intid,name,studentid,idcard,birthday);
        String flag=userInformationService.updateuserinformation(userInformation);
        return flag;
    }

    //更新个人信息
    @RequestMapping(value = "/owninfo_alter",method = RequestMethod.POST)
    @ResponseBody
    public String updateowninfo(String name,String studentid,String idcard,String birthday)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        UserInformation userInformation=userInformationService.getbyusername(username);
        userInformation.setName(name);
        userInformation.setStudentid(studentid);
        userInformation.setIdcard(idcard);
        userInformation.setBirthday(birthday);
        String site=userInformationService.updateuserinformation(userInformation);
        return site;
    }

    //全部用户权限查询
    @RequestMapping(value = "/getuser",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getuser()
    {
        List<User> users=new ArrayList<User>();
        users=userService.getalluser();
        return users;
    }

    //用户权限升级管理员
    @RequestMapping(value = "/level_up",method = RequestMethod.POST)
    @ResponseBody
    public String uptoauth(int id)
    {
        User user=userService.userbuilder(id,"A","null","null");
        String site=userService.updateuser(user);
        return site;
    }

    //用户权限降级普通用户
    @RequestMapping(value = "level_down",method = RequestMethod.POST)
    @ResponseBody
    public String downtopeople(int id)
    {
        User user=userService.userbuilder(id,"M","null","null");
        String site=userService.updateuser(user);
        return site;
    }

    //删除用户，用户信息
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    @ResponseBody
    public String removeuser(int id)
    {
        User user=userService.getbyid(id);
        String site=userService.deleteuser(id);
        String site2=userInformationService.deletewithuser(user.getUsername());
        if (site.equals("Y") && site2.equals("Y"))
            return "Y";
        else
            return "N";
    }

    //更新系统说明
    @RequestMapping(value = "/alter_sysnotice",method = RequestMethod.POST)
    @ResponseBody
    public String updatenotice(String type,String noticedate,String content)
    {
        Notice notice=noticeService.noticebuilder(type,noticedate,content);
        String site=noticeService.deletenotice(type);
        String site2=noticeService.addnotice(notice);
        if (site.equals("Y") && site2.equals("Y"))
            return "Y";
        else
            return "N";
    }

    //bill查询
    @RequestMapping(value = "/getbill",method = RequestMethod.POST)
    @ResponseBody
    public List<Bill> getbills()
    {
        List<Bill> bills=new ArrayList<Bill>();
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user=userService.getbyusername(username);
        if (user.getAuthority().equals("M"))
            bills=billService.getbyname(username);
        else
            bills=billService.getall();
        return bills;
    }

    //删除报销
    @RequestMapping(value = "/deletebill",method = RequestMethod.POST)
    @ResponseBody
    public String dodeletebill(int id)
    {
        String site=billService.deletebill(id);
        return site;
    }

    //通过审核
    @RequestMapping(value = "/bill_success",method = RequestMethod.POST)
    @ResponseBody
    public String billsuccess(int id)
    {
        Bill bill=billService.billbuilder(id,"Y");
        String site=billService.updatebillbyid(bill);
        return site;
    }

    //拒绝报销
    @RequestMapping(value = "/bill_refuse",method = RequestMethod.POST)
    @ResponseBody
    public String billrefuse(int id)
    {
        Bill bill=billService.billbuilder(id,"N");
        String site=billService.updatebillbyid(bill);
        return site;
    }

    //新增报销
    @RequestMapping(value = "/new_bill",method = RequestMethod.POST)
    @ResponseBody
    public String donewbill(String username,float money,String billtime,String billtype,String billpattern,String studentid,String invoice,String buyer,String seller,String paymentways,String billcontent)
    {
        Bill bill=billService.billsbuilder(0,username,money,billtime,billtype,billpattern,studentid,invoice,buyer,seller,paymentways,billcontent,"N");
        String site=billService.addbill(bill);
        return site;
    }

    //查询未通过报销(根据state查询)
    @RequestMapping(value = "/getcheckbill",method = RequestMethod.POST)
    @ResponseBody
    public List<Bill> getcheckbill()
    {
        List<Bill> bills=new ArrayList<>();
        bills=billService.getbystate("N");
        return bills;
    }

}
