package com.qihang.model;

import com.mysql.fabric.xmlrpc.base.Data;

public class Leave {
    private int id;
    private String tName;
    private String lName1;
    private String lName2;
    private String place;
    private String reason;
    private String phone;
    private String leaveTime;
    private Data subTime;

    public Leave(){}
    public Leave(int id, String tName, String lName1, String lName2, String place, String reason, String phone, String leaveTime, Data subTime) {
        this.id = id;
        this.tName = tName;
        this.lName1 = lName1;
        this.lName2 = lName2;
        this.place = place;
        this.reason = reason;
        this.phone = phone;
        this.leaveTime = leaveTime;
        this.subTime = subTime;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", tName='" + tName + '\'' +
                ", lName1='" + lName1 + '\'' +
                ", lName2='" + lName2 + '\'' +
                ", place='" + place + '\'' +
                ", reason='" + reason + '\'' +
                ", phone='" + phone + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", subTime=" + subTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getlName1() {
        return lName1;
    }

    public void setlName1(String lName1) {
        this.lName1 = lName1;
    }

    public String getlName2() {
        return lName2;
    }

    public void setlName2(String lName2) {
        this.lName2 = lName2;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Data getSubTime() {
        return subTime;
    }

    public void setSubTime(Data subTime) {
        this.subTime = subTime;
    }
}
