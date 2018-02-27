package com.qihang.dao;


import com.qihang.model.Post;
import org.apache.ibatis.annotations.Select;

import static com.qihang.util.TableConstants.ATTRPOST;

public interface PostDao {
    /*查*/
    @Select(value = "select post from "+ATTRPOST+" where id = #{id}")
    Post selectPostById(int id);
    /*增*/

    /*删*/

    /*改*/


}
