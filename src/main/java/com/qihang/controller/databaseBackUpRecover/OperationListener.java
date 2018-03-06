package com.qihang.controller.databaseBackUpRecover;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

/**
 * 时间监听器,用于定时备份数据库
 */
public class OperationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            new TimerManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
