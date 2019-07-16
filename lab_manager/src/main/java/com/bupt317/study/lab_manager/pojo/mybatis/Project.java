package com.bupt317.study.lab_manager.pojo.mybatis;


public class Project
{
    private int id;
    private String projectname;
    private String member;
    private String projectmessage;
    private String starttime;
    private String endtime;
    private String projectstate;
    private String other;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getProjectmessage() {
        return projectmessage;
    }

    public void setProjectmessage(String projectmessage) {
        this.projectmessage = projectmessage;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getProjectstate() {
        return projectstate;
    }

    public void setProjectstate(String projectstate) {
        this.projectstate = projectstate;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
