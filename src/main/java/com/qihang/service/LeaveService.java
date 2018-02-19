package com.qihang.service;

import com.qihang.model.Leave;

import java.util.List;

public interface LeaveService {

    List<Leave> getAllLeave();
    int addLeave(Leave leave);
    List<Leave> getLeaveByUser(String name,int num);
}
