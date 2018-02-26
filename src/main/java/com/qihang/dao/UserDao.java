package com.qihang.dao;

import com.qihang.model.User;
import com.qihang.model.User2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import static com.qihang.util.TableConstants.TABLEUSER;

public interface UserDao {
    /*查*/

    @Select(value = "select * from "+TABLEUSER+" where name = #{name} and password = #{pass}")
    User testUser(@Param("name") String name,@Param("pass") String pass);
    @Select(value = "select name from "+ TABLEUSER+" where id = #{id}")
    User selectUserById(@Param("id") int id);
    @Select(value = "select name from "+ TABLEUSER+" where id = #{id}")
    User2 selectUserById2(@Param("id") int id);

    //根据系和职务查询姓名与id
    @Select(value = "select id,name from " + TABLEUSER + " where power = #{right} and system = #{system}")
    List<User> SelectUserByRiSy(@Param("right") int right, @Param("system") int system);



    /*增*/

    /*删*/

    /*改*/
    @Update(value = "update "+TABLEUSER+" set password = #{pass} where id = #{id}")
    int updatePassword(@Param("pass") String pass,@Param("id") int id);

}
