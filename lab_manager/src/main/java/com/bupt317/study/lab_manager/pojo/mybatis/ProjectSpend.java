package com.bupt317.study.lab_manager.pojo.mybatis;


public class ProjectSpend
{
    private int id;
    private String projectname;
    private String spenddate;
    private float money;
    private String attention;

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

    public String getSpenddate() {
        return spenddate;
    }

    public void setSpenddate(String spenddate) {
        this.spenddate = spenddate;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }
}
