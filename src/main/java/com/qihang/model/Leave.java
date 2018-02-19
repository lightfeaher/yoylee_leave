package com.qihang.model;

import java.util.Date;

public class Leave {
    private int id;
    private String uTname;
    private String uLname1;
    private String uLname2;
    private String leader1;
    private String leader2;
    private String place;
    private String reason;
    private String phone;
    private String leaveTime;
    private Date subTime;

    public Leave(){}

    public Leave(int id, String uTname, String uLname1, String uLname2, String leader1, String leader2, String place, String reason, String phone, String leaveTime, Date subTime) {
        this.id = id;
        this.uTname = uTname;
        this.uLname1 = uLname1;
        this.uLname2 = uLname2;
        this.leader1 = leader1;
        this.leader2 = leader2;
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
                ", uTname='" + uTname + '\'' +
                ", uLname1='" + uLname1 + '\'' +
                ", uLname2='" + uLname2 + '\'' +
                ", leader1='" + leader1 + '\'' +
                ", leader2='" + leader2 + '\'' +
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

    public String getuTname() {
        return uTname;
    }

    public void setuTname(String uTname) {
        this.uTname = uTname;
    }

    public String getuLname1() {
        return uLname1;
    }

    public void setuLname1(String uLname1) {
        this.uLname1 = uLname1;
    }

    public String getuLname2() {
        return uLname2;
    }

    public void setuLname2(String uLname2) {
        this.uLname2 = uLname2;
    }

    public String getLeader1() {
        return leader1;
    }

    public void setLeader1(String leader1) {
        this.leader1 = leader1;
    }

    public String getLeader2() {
        return leader2;
    }

    public void setLeader2(String leader2) {
        this.leader2 = leader2;
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

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }
}
