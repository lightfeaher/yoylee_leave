package com.qihang.dao;

import com.qihang.model.System;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.qihang.util.TableConstants.ATTRSYSTEM;

public interface SystemDao {
    /*查*/
    @Select(value = "select * from "+ATTRSYSTEM)
    List<System> selectSystem();
    @Select(value = "select system from "+ATTRSYSTEM+" where id = #{id}")
    System selectSystemById(int id);
    /*增*/

    /*删*/

    /*改*/
}
