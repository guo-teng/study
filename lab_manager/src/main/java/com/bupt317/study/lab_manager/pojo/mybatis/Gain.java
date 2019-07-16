package com.bupt317.study.lab_manager.pojo.mybatis;


public class Gain
{
    private int id;
    private String gaindate;
    private float money;
    private String attention;
    private String more;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGaindate() {
        return gaindate;
    }

    public void setGaindate(String gaindate) {
        this.gaindate = gaindate;
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

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
