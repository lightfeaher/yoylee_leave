package com.qihang.dao;

import com.qihang.dao.provider.LeaveDynaSqlProvider;
import com.qihang.model.Leave;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.qihang.util.TableConstants.TABLELEAVE;

public interface LeaveDao {

    /*查*/
    @SelectProvider(type = LeaveDynaSqlProvider.class,method = "selectAllLeave")
    List<Leave> selectAllLeave(String powerId,int sysId,int userId);
    @SelectProvider(type = LeaveDynaSqlProvider.class,method = "selectLeaveByLike")
    List<Leave> selectLeaveByLike(int orApprove,int systemId,String name,String powerId,int sysId,int userId);

    @SelectProvider(type = LeaveDynaSqlProvider.class,method = "selectLeaveByUser")
    List<Leave> selectLeaveByUser(String name,int num);

//    @Select(value = "select * from "+TABLELEAVE+" where ")

    @Select(value = "select * from "+TABLELEAVE+" where u_id = #{uId} and ((leader1 = 1 and leader2 = 1) or (leader1 = 2 and leader2 = 1))")
    List<Leave> selectPrivateLeave(int uId);

    /*增*/
    @Insert(value = "insert into "+TABLELEAVE+" values(null,#{leave.uId},#{leave.uSys},#{leave.uTname},#{leave.uLname1},#{leave.uLname2},#{leave.leader1},#{leave.leader2},#{leave.place},#{leave.reason},#{leave.phone},#{leave.leaveTime},#{leave.subTime})")
    @Options(useGeneratedKeys=true,keyProperty="leave.id")
    int insertLeave(@Param("leave") Leave leave);  //!!!!这个地方的@Param必须加,因为他是一个对象
    /*删*/
    @Delete(value = "delete from "+TABLELEAVE+" where id = #{delId}")
    int deleteLeave(int delId);
    /*改*/
    @UpdateProvider(type = LeaveDynaSqlProvider.class,method = "updateLeave")
    int updateLeave(int leaveId,int numId,String powerId);
}
