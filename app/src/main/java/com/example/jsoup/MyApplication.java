package com.example.jsoup;

import android.app.Application;
import android.content.Context;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/1
 * Time: 16:17
 */
public class MyApplication extends Application {

    private static MyApplication mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static MyApplication getContext(){
        return mContext;
    }
}
