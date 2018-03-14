package com.qihang.controller.databaseBackUpRecover;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.qihang.util.TableConstants.sqlNum;


/**
 * 定时备份数据库
 */

public class DatabaseBackUpRecoverTime {

    //读取配置文件中的信息
    //MySql的安装bin目录路径和dump等参数
    static String sqlurl=GetProperties.getSqlurl();
    //保存备份文件的路径及名称
    static String path=GetProperties.getPath();

    public DatabaseBackUpRecoverTime() throws IOException {
        backup(); // 备份数据库
        System.out.println("备份数据库成功!");
    }

    public static void backup(){
        try {
            //返回与当前的Java应用程序的运行时对象
            Runtime rt =Runtime.getRuntime();
            // 调用 调用mysql的安装目录的命令
            Process child = rt.exec(sqlurl);
            // 设置导出编码为utf-8。这里必须是utf-8
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            // 要用来做导入用的sql目标文件：

            //组合导出的文件名添加备份日期,防止相互覆盖
            Date date = new Date();
            SimpleDateFormat f = new SimpleDateFormat("MM-dd");
            //sqlNum为一个自定义工具类中的static类型的Date变量,自己设置即可
            sqlNum = f.format(date);
            path = path.split("-")[0]+"-"+sqlNum+".sql";
            FileOutputStream fout = new FileOutputStream(path);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
