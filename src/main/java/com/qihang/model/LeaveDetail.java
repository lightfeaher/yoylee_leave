package com.qihang.model;

import java.util.Date;

public class LeaveDetail {
    private int id;
    private int uId;
    private int uSys;
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

    private System system;
    private User user;
    private User2 user2;

    public LeaveDetail(){}

    public LeaveDetail(int id, int uId, int uSys, String uTname, String uLname1, String uLname2, String leader1, String leader2, String place, String reason, String phone, String leaveTime, Date subTime) {
        this.id = id;
        this.uId = uId;
        this.uSys = uSys;
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
        return "LeaveDetail{" +
                "id=" + id +
                ", uId=" + uId +
                ", uSys=" + uSys +
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
                ", system=" + system +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getuSys() {
        return uSys;
    }

    public void setuSys(int uSys) {
        this.uSys = uSys;
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

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User2 getUser2() {
        return user2;
    }

    public void setUser2(User2 user2) {
        this.user2 = user2;
    }
}
