package com.example.jsoup;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.jsoup.utils.AppActivityManager;
import com.example.jsoup.utils.ToastUtils;
import com.example.jsoup.utils.UIUtils;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class  BaseActivity extends RxAppCompatActivity implements BaseView{

    protected Context mContext;
    protected Unbinder mUnbinder;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无ActionBar，单在继承AppCompatActivity时无效，继承Activity时才有效
        //保持竖屏
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AppActivityManager.getInstance().addActivity(this);//新建时添加到栈

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        mContext =this;
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        if (mUnbinder!=null)mUnbinder.unbind();
        super.onDestroy();

    }

    @Override
    public void showToast(String s) {
        ToastUtils.showToast(s);
    }
}
