package com.qihang.controller.databaseBackUpRecover;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class   GetProperties {

    private static  String sqlurl = "";
    private static  String path = "";
    private static long distancetime = 0;
    private static  String backuptime = "";

    static {
        /**通过这个方法只能读取类路径下的properties文件*/
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = GetProperties.class.getClassLoader().getResourceAsStream("dbBackUpRecover.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取key对应的value值
        sqlurl = properties.getProperty("sqlurl");
        path = properties.getProperty("path");
        distancetime = Long.parseLong(properties.getProperty("distancetime"));
        backuptime = properties.getProperty("backuptime");
    }

    public static String getSqlurl() {
        return sqlurl;
    }

    public static void setSqlurl(String sqlurl) {
        GetProperties.sqlurl = sqlurl;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        GetProperties.path = path;
    }

    public static long getDistancetime() {
        return distancetime;
    }

    public static void setDistancetime(long distancetime) {
        GetProperties.distancetime = distancetime;
    }

    public static String getBackuptime() {
        return backuptime;
    }

    public static void setBackuptime(String backuptime) {
        GetProperties.backuptime = backuptime;
    }
}
