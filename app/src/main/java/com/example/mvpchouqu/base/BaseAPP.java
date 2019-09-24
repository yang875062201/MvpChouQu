package com.example.mvpchouqu.base;

import android.app.Application;

public class BaseAPP extends Application {
    public static BaseAPP sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
