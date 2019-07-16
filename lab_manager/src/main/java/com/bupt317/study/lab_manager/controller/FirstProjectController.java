package com.bupt317.study.lab_manager.controller;

import com.bupt317.study.lab_manager.pojo.mybatis.Payment;
import com.bupt317.study.lab_manager.pojo.mybatis.Project;
import com.bupt317.study.lab_manager.pojo.mybatis.ProjectSpend;
import com.bupt317.study.lab_manager.pojo.mybatis.User;
import com.bupt317.study.lab_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstProjectController
{
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectSpendService projectSpendService;
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    PaymentService paymentService;


    //权限不足访问页面
    @RequestMapping(value = "/deny")
    public String todeny()
    {
        return "deny";
    }

    //用户管理页面跳转
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/usermanager")
    public String tousermanager()
    {
        return "usermanager";
    }

    //跳转home页面
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/home")
    public String tohome()
    {
        return "home";
    }

    //program页面跳转
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/program")
    public String toprogram()
    {
        return "program";
    }

    //projectspend页面跳转
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/secondpage/projectspend")
    public String toprojectspend()
    {
        return "/secondpage/projectspend";
    }

    //program—new页面跳转
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value ="/secondpage/new" )
    public String toprogramnew()
    {
        return "/secondpage/new";
    }

    //program-alter页面跳转
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/secondpage/alter")
    public String toprogramalter()
    {
        return "/secondpage/alter";
    }

    //program-graph页面跳转
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/secondpage/graph")
    public String toprogramgraph()
    {
        return "/secondpage/graph";
    }

    //注册页面跳转
    @RequestMapping(value = "/register")
    public String toregister()
    {
        return "/register";
    }

    //登陆验证
    @RequestMapping(value = {"/index","/"})
    public String tologin()
    {
        return"index";
    }

    //program查询
    @RequestMapping(value = ("/project"),method = RequestMethod.POST)
    @ResponseBody
    public List<Project> getprogram()
    {
        List<Project> projects=new ArrayList<Project>();
        projects=projectService.getall();
        return projects;
    }

    //根据id查询program
    @RequestMapping(value = ("/program_byid"),method = RequestMethod.POST)
    @ResponseBody
    public Project getprogrambyid(int id)
    {
        Project project=projectService.getbyid(id);
        return project;
    }

    //新建program
    @RequestMapping(value = "/program_new",method = RequestMethod.POST)
    @ResponseBody
    public String addprogram(String projectname,String member,String projectmessage,String starttime,String endtime,String projectstate)
    {
        Project project=projectService.projectbuilder(0,projectname,member,projectmessage,starttime,endtime,projectstate);
        String site=projectService.addproject(project);
        ProjectSpend projectSpend=projectSpendService.projectspendbuilder(projectname,0,starttime,"null");
        String site2=projectSpendService.addprojectspend(projectSpend);
        if (site.equals("Y") && site2.equals("Y"))
            return "Y";
        else
            return "N";
    }

    //修改program
    @RequestMapping(value = "/program_alter",method = RequestMethod.POST)
    @ResponseBody
    public String updateprogram(String id,String projectname,String member,String projectmessage,String starttime,String endtime,String projectstate)
    {
        int nid=Integer.parseInt(id);
        Project project=projectService.projectbuilder(nid,projectname,member,projectmessage,starttime,endtime,projectstate);
        String site=projectService.updateproject(project);
        return site;
    }

    //查询所有项目名
    @RequestMapping(value = "/get_allprojectname",method = RequestMethod.POST)
    @ResponseBody
    public List<ProjectSpend> getallprojectspend()
    {
        List<ProjectSpend> projectSpends=new ArrayList<>();
        projectSpends=projectSpendService.getall();
        return projectSpends;
    }

    //新建项目花销
    @RequestMapping(value = "/projectspend_new",method = RequestMethod.POST)
    @ResponseBody
    public String createprojectspend(String projectname,float money,String spenddate,String attention)
    {
        Payment payment=paymentService.paymentbuilder(0,spenddate,money,attention,"nothing");
        String site2=paymentService.addpayment(payment);
        ProjectSpend projectSpend=projectSpendService.projectspendbuilder(projectname,money,spenddate,attention);
        String site=projectSpendService.addprojectspend(projectSpend);
        if (site.equals("Y") && site2.equals("Y"))
            return "Y";
        else
            return "N";
    }

    //花销图表创建
    @RequestMapping(value = "/program_graph",method = RequestMethod.POST)
    @ResponseBody
    public List<ProjectSpend> createprogramgraph(String projectname)
    {
        List<ProjectSpend> projectSpends=new ArrayList<ProjectSpend>();
        projectSpends=projectSpendService.getbyprojectname(projectname);
        //System.out.println(projectname);
        return projectSpends;
    }

    //注册处理
    @RequestMapping(value = "/register_user",method = RequestMethod.POST)
    public String doregister(Model model,String username,String studentid,String password,String repassword)
    {
        if (userService.checkusername(username).equals("N"))
        {
            model.addAttribute("alert","用户名重复");
            return "/register";
        }

        if (!password.equals(repassword))
        {
            model.addAttribute("alert","两次的密码不一样");
            System.out.println(password);
            return "/register";
        }
        else
        {
            BCryptPasswordEncoder bcpe=new BCryptPasswordEncoder();
            String bcpasword=bcpe.encode(password);
            //System.out.println(bcpasword);
            User user=userService.userbuilder(0,"M",username,bcpasword);
            String adduserback=userService.adduser(user);
            String adduserinformationback=userInformationService.addwithuser(username,"unknown",studentid);
            if (adduserback.equals("Y")&&adduserinformationback.equals("Y"))//写入数据库
                    return "/index";
            else
                return "/register";
        }
    }


}
