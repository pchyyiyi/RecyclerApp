package com.pchyyiyi.recyclerapp;

import android.app.Application;
import android.content.Context;

/**
 * @ClassName RecyclerApplication
 * @Description TODO
 * @Author fayXxxx
 * @Date 2021/6/1 上午10:54
 * @Version 1.0
 */
public class RecyclerApplication extends Application {
    private static RecyclerApplication instance = null;

    public static Context getAppContext() {
        return instance;
    }

    /**
     * 获取该应用唯一的实例
     * @return
     */
    public static RecyclerApplication getInstance() {
        return instance;
    }

    //交易记录按月份分类全局变量
    public static String currentMonth = "000000";


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


}
