package com.example.jsoup.aadaggertest;

import android.widget.Button;

import com.example.jsoup.BaseActivity;
import com.example.jsoup.R;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/2
 * Time: 16:42
 */
public class DaggerActivity extends BaseActivity implements ActivityComponent {
    @BindView(R.id.main_bt )
    Button mButton;
    @Inject User mUser;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

//        ActivityComponent.builder().build().inject(this);
        mUser.setUserName("123");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject(DaggerActivity daggerActivity) {

    }
}
