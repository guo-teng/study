package com.bupt317.study.lab_manager.pojo.mybatis;


public class UserInformation
{
    private int id;
    private String username;
    private String name;
    private String idcard;
    private String studentid;
    private String birthday;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
