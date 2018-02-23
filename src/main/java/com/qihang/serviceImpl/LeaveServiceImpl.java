package com.qihang.serviceImpl;

import com.qihang.dao.LeaveDao;
import com.qihang.model.Leave;
import com.qihang.service.LeaveService;
import com.qihang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveDao leaveDao;

    public List<Leave> getAllLeave(String powerId,int sysId,int userId){
        return leaveDao.selectAllLeave(powerId,sysId,userId);
    }
    public List<Leave> getLeaveByLike(int orApprove,int systemId,String name,String powerId,int sysId,int userId){
        return leaveDao.selectLeaveByLike(orApprove,systemId,name,powerId,sysId,userId);
    }

    public int addLeave(Leave leave) {
        return leaveDao.insertLeave(leave);
    }

    public List<Leave> getLeaveByUser(String name, int num) {
        return leaveDao.selectLeaveByUser(name,num);
    }

    public int approveLeave(int leaveId, int numId, String powerId) {
        return leaveDao.updateLeave(leaveId,numId,powerId);
    }

    public List<Leave> getPrivateLeave(int uId) {
        return leaveDao.selectPrivateLeave(uId);
    }

    public int removeLeave(int delId) {
        return leaveDao.deleteLeave(delId);
    }
}
