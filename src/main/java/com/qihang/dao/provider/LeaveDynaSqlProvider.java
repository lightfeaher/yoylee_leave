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
    public String selectLeaveByLike(final int orApprove,final int systemId,final String name,final String powerId,final int sysId,final int userId){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(TABLELEAVE);
                //教师(查询自己的请假记录)
                if (powerId.equals("1")){
                    WHERE(" u_id = "+userId);
                    //批准
                    if (orApprove == 0)
                        WHERE(" leader1 = 2 and leader2 = 2");
                    //未批准
                    if (orApprove == 1)
                        WHERE(" leader1 != 2 and leader2 != 2");
                }
                //中层领导
                if (powerId.equals("2")){
                    WHERE(" u_sys = "+sysId);
                    //批准
                    if (orApprove == 1)
                        WHERE(" leader1 = 2 and leader2 = 2");
                    //未批准
                    if (orApprove == 2)
                        WHERE(" leader1 != 2 and leader2 != 2");
                    //姓名查("利用正则表达式去除空格情况")
                    if (name.replaceAll("\\s+","") .equals("")){
                        WHERE(" u_tname = "+name);
                    }
                }
                if (powerId.equals("3")||powerId.equals("4")){
                    //批准
                    if (orApprove == 1)
                        WHERE(" leader1 = 2 and leader2 = 2");
                    //未批准
                    if (orApprove == 2)
                        WHERE(" leader1 != 2 or leader2 != 2");
                    //姓名查("利用正则表达式去除空格情况")
                    if (!(name.replaceAll("\\s+","") .equals(""))){
                        WHERE(" u_tname like '%"+name+"%'");
                    }
                    //根据系查询(去除 不限 的情况)
                    if (systemId != 0){
                        WHERE(" u_sys = "+systemId);
                    }
                }

                ORDER_BY(" sub_time desc");
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
