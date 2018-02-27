package com.qihang.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import static com.qihang.util.TableConstants.TABLEUSER;

public class UserDynaSqlProvider {
    public String selectUserByLike(final int systemId,final String name){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(TABLEUSER);
                if (systemId!=0){
                    WHERE(" system = "+systemId);
                }
                if (!(name.replaceAll("\\s+","") .equals(""))){
                    WHERE(" name like '%"+name+"%'");
                }
            }
        }.toString();
        return sql;
    }
    public String selectUserByRiSy(final int right,final int system){
        String sql = new SQL(){
            {
                SELECT("id,name");
                FROM(TABLEUSER);
                WHERE(" post = "+right);
                if (system != 0){
                    WHERE(" system = "+system);
                }
            }
        }.toString();
        return sql;
    }
}
