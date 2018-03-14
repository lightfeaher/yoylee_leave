package com.qihang.controller.databaseBackUpRecover;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 定时时间详细设置
 */
public class TimerManager {

    //时间间隔 1天时间
    private static final long PERIOD_DAY = GetProperties.getDistancetime();

    //构造函数进行
    public TimerManager() throws IOException {
        //获取并处理配置文件中的时间
        /**备份的确切时间*/
        String backuptime=GetProperties.getBackuptime();

        String[] time=backuptime.split(":");
        int hours=Integer.parseInt(time[0]);
        int minute=Integer.parseInt(time[1]);
        int second=Integer.parseInt(time[2]);

        //调用util包中的日历,设置时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hours);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        Date date=calendar.getTime(); //第一次执行定时任务的时间

        //如果第一次执行定时任务的时间 小于 当前的时间
        //此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
        if (date.before(new Date())) {
            date = this.addDay(date, 1);
        }

        //启动定时器控件
        Timer timer = new Timer();

        OperationTimer task = new OperationTimer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule(task,date,PERIOD_DAY);
    }

    // 增加或减少天数
    public Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }
}
