package com.example.jsoup.aadaggertest;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/2
 * Time: 17:09
 */
@Component
public interface ActivityComponent{
    void inject(DaggerActivity daggerActivity);

}
