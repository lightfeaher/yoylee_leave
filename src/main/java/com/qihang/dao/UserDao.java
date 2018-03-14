package com.qihang.dao;

import com.qihang.dao.provider.UserDynaSqlProvider;
import com.qihang.model.User;
import com.qihang.model.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.qihang.util.TableConstants.TABLEUSER;

public interface UserDao {
    /*查*/

    @Select(value = "select id,name,post,system from " + TABLEUSER )
    @Results({
            @Result(property = "po",column = "post",one = @One(select = "com.qihang.dao.PostDao.selectPostById")),
            @Result(property = "sys",column = "system",one = @One(select = "com.qihang.dao.SystemDao.selectSystemById"))
    })
    List<User2> selectAllUser();

    @SelectProvider(type = UserDynaSqlProvider.class,method = "selectUserByLike")
    @Results({
            @Result(property = "po",column = "post",one = @One(select = "com.qihang.dao.PostDao.selectPostById")),
            @Result(property = "sys",column = "system",one = @One(select = "com.qihang.dao.SystemDao.selectSystemById"))
    })
    List<User2> selectUserByLike(int systemId,String name);


    @Select(value = "select * from "+TABLEUSER+" where name = #{name} and password = #{pass}")
    User testUser(@Param("name") String name,@Param("pass") String pass);

    @Select(value = "select name,post,system from "+ TABLEUSER+" where id = #{id}")
    User selectUserById(@Param("id") int id);

    @Select(value = "select name from "+ TABLEUSER+" where id = #{id}")
    User2 selectUserById2(@Param("id") int id);

    //根据系和职务查询姓名与id
    @SelectProvider(type = UserDynaSqlProvider.class,method = "selectUserByRiSy")
    List<User> SelectUserByRiSy(int right,int system);




    /*增*/
    @Insert(value = "insert into "+TABLEUSER+" values(null,#{user.name},#{user.password},#{user.post},#{user.system})")
    @Options(useGeneratedKeys = true,keyProperty = "user.id")
    int insertUser(@Param("user") User user);
    /*删*/
    @Delete(value = "delete from "+TABLEUSER+" where id = #{id}")
    int deleteUser(@Param("id") int id);
    /*改*/
    @Update(value = "update "+TABLEUSER+" set password = #{pass} where id = #{id}")
    int updatePassword(@Param("pass") String pass,@Param("id") int id);

    @Update(value = "update "+TABLEUSER+" set password = #{pass} where name = #{name}")
    int resetPassword(@Param("pass") String pass,@Param("name") String name);

    @Update(value = "update "+TABLEUSER+" set name = #{user.name},post = #{user.post},system = #{user.system} where id = #{user.id}")
    int updateUser(@Param("user") User user);

}
