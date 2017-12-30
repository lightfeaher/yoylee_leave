package com.qihang.dao;

import com.qihang.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import static com.qihang.util.TableConstants.TABLEUSER;

public interface UserDao {
    /*查*/

    @Select(value = "select * from "+ TABLEUSER+" where id = #{id}")
    User SelectOneUserById(@Param("id") int id);

    //根据系和职务查询姓名
    @Select(value = "select name from " + TABLEUSER + " where power = #{right} and system = #{system}")
    String[] SelectUserByRiSy(@Param("right") int right,@Param("system") int system);



    /*增*/

    /*删*/

    /*改*/


}
