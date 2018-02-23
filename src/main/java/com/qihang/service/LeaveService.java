package com.qihang.service;

import com.qihang.model.Leave;

import java.util.List;

public interface LeaveService {

    List<Leave> getAllLeave(String powerId,int sysId,int userId);
    List<Leave> getLeaveByLike(int orApprove,int systemId,String name,String powerId,int sysId,int userId);
    int addLeave(Leave leave);
    List<Leave> getLeaveByUser(String name,int num);
    int approveLeave(int leaveId,int numId,String powerId);
    List<Leave> getPrivateLeave(int uId);
    int removeLeave(int delId);
}
