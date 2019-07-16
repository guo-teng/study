package com.bupt317.study.lab_manager.pojo.mybatis;


public class Bill
{
    private int id;
    private String billtype;
    private String billpattern;
    private String name;//实际上是username
    private String studentid;
    private float money;
    private String billtime;
    private String paymentways;
    private String billcontent;
    private String invoice;
    private String buyer;
    private String seller;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getBillpattern() {
        return billpattern;
    }

    public void setBillpattern(String billpattern) {
        this.billpattern = billpattern;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getBilltime() {
        return billtime;
    }

    public void setBilltime(String billtime) {
        this.billtime = billtime;
    }

    public String getPaymentways() {
        return paymentways;
    }

    public void setPaymentways(String paymentways) {
        this.paymentways = paymentways;
    }

    public String getBillcontent() {
        return billcontent;
    }

    public void setBillcontent(String billcontent) {
        this.billcontent = billcontent;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
}
