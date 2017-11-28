package com.qihang.dao;

import com.qihang.models.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserTest {

    @Select("select * from user_teacher where name = #{name}" )
    Teacher selectByLoginnameAndPassword(
            @Param("name") String name);


}
