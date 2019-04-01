package com.example.jsoup;

import android.os.Handler;

import com.example.jsoup.MyApplication;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/1
 * Time: 16:22
 */
public class JsoupApplication extends MyApplication {
    public static int mMainThreadId;
    public static Handler mHandler;
//    public AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
    }

    /**
     * 返回主线程的pid
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }
    /**
     * 返回Handler
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }

}
