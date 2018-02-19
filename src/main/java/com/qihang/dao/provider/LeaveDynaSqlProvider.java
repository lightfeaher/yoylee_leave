package com.qihang.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import static com.qihang.util.TableConstants.TABLELEAVE;

public class LeaveDynaSqlProvider {
    public String selectLeaveByUser(final String name,final int num){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(TABLELEAVE);
                if (num == 0)
                    WHERE(" u_lname1 = "+name+" and leader1 = '1'");
                if (num == 1)
                    WHERE(" u_lname2 = "+name+" and leader1 = '2'");

            }
        }.toString();
        return sql;
    }
}
