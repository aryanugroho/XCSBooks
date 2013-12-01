package com.example.xcsbooks.control;

import java.net.CookieHandler;
import java.net.CookieManager;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        CookieManager cm = new CookieManager(new myCookieStore(this), java.net.CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cm);
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}