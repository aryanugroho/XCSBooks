package com.example.xcsbooks.control;

import java.net.CookieHandler;
import java.net.CookieManager;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
    
    private static Context context;

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
