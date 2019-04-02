package com.example.jsoup.aadaggertest;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/2
 * Time: 16:43
 */
public class User {
    private String UserName;
    private String UserAge;

    @Inject
    public User() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }
}
