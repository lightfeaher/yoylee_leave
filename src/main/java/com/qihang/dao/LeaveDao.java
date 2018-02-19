package com.qihang.dao;

import com.qihang.dao.provider.LeaveDynaSqlProvider;
import com.qihang.model.Leave;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.qihang.util.TableConstants.TABLELEAVE;

public interface LeaveDao {

    /*查*/
    @Select(value = "select * from "+TABLELEAVE)
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "place", column = "place")
//    })
    List<Leave> selectAllLeave();

    @SelectProvider(type = LeaveDynaSqlProvider.class,method = "selectLeaveByUser")
    List<Leave> selectLeaveByUser(String name,int num);

    /*增*/
    @Insert(value = "insert into "+TABLELEAVE+" values(null,#{leave.uTname},#{leave.uLname1},#{leave.uLname2},#{leave.leader1},#{leave.leader2},#{leave.place},#{leave.reason},#{leave.phone},#{leave.leaveTime},#{leave.subTime})")
    @Options(useGeneratedKeys=true,keyProperty="leave.id")
    int insertLeave(@Param("leave") Leave leave);
    /*删*/

    /*改*/
}
