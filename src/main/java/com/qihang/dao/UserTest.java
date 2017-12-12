package com.qihang.dao;

import com.qihang.models.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserTest {

    @Select("select * from user_teacher where id = #{name}" )
    Teacher selectByLoginnameAndPassword(
            @Param("name") String name);
    @Delete("delete  from user_teacher where id = #{name}" )
    int deleteByLoginnameAndPassword(
            @Param("name") String name);


}
