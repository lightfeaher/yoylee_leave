package com.qihang.controller.databaseBackUpRecover;

import java.io.IOException;
import java.util.TimerTask;

public class OperationTimer extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    //所要执行内容
    public void run() {
        try {
            new DatabaseBackUpRecoverTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
