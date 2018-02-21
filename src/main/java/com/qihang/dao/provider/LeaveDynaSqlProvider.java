package com.qihang.dao.provider;

import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.javassist.runtime.Desc;
import org.apache.ibatis.jdbc.SQL;

import static com.qihang.util.TableConstants.TABLELEAVE;

public class LeaveDynaSqlProvider {
    public String selectAllLeave(final String powerId,final int sysId,final int userId){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(TABLELEAVE);
                //教师(查询自己的请假记录)
                if (powerId.equals("1")){
                    WHERE(" u_id = "+userId);
                }
                //中层领导
                if (powerId.equals("2")){
                    WHERE(" u_sys = "+sysId);
                }
                ORDER_BY(" sub_time desc");
                //高层领导和院办主任便是查询所有的
            }
        }.toString();
        return sql;
    }
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
    public String updateLeave(final int leaveId,final int numId,final String powerId){
        String sql = new SQL(){
            {
              UPDATE(TABLELEAVE);
              //中层领导
              if (powerId.equals("2")||powerId.equals("4")){
                  //批准
                  if (numId == 1)
                    SET("leader1 = 2");
                  else //未批准
                      SET("leader1 = 3");
              }
              //高层领导
              if (powerId.equals("3")){
                  //批准
                  if (numId == 1)
                    SET("leader2 = 2");
                  else //未批准
                      SET("leader2 = 3");
              }
              WHERE("id = "+leaveId);
            }
        }.toString();
        return sql;
    }
}
