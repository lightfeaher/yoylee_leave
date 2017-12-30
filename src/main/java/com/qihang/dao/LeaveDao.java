package com.qihang.dao;

import com.qihang.model.Leave;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.qihang.util.TableConstants.TABLELEAVE;

public interface LeaveDao {

    /*查*/
    @Select(value = "select * from "+TABLELEAVE)
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "place", column = "place")
//    })
    List<Leave> SelectAllLeave();

    /*增*/

    /*删*/

    /*改*/
}
