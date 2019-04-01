package com.example.jsoup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jsoup.view.LoadingPager;
import com.trello.rxlifecycle3.components.support.RxFragment;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragmentLoading extends RxFragment implements BaseView{

    protected Unbinder mUnbinder;
    protected BaseActivity mContext;
    LoadingPager mLoadingPager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        initData();
    }

    protected abstract void initData();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (mLoadingPager==null){
            mLoadingPager = new LoadingPager( mContext) {
                @Override
                protected View cretaeSuccessView() {
                    return BaseFragmentLoading.this.cretaeSuccessView();
                }

                @Override
                protected void load() {
                    this.load();
                }
            };
        }
        return  mLoadingPager;
    }

    protected abstract int getlayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        mUnbinder.unbind();
        super.onDestroyView();
    }

    //.....
    /**
     * 调用父类的方法(请求网络 修改状态)
     */
    public void show() {
        if (mLoadingPager != null) {
            mLoadingPager.show();
        }
    }

    /**
     * 调用父类的方法(设置状态)
     *
     * @param result
     */
    public void setState(LoadingPager.LoadResult result) {
        if (mLoadingPager != null) {
            mLoadingPager.setState(result);
        }
    }

    /**
     * 加载成功的界面
     *
     * @return 显示子类相应的布局
     */
    protected abstract View cretaeSuccessView();

    /**
     * 请求网络 根据结果传入相应状态
     */
    protected abstract void load();

    @Override
    public void showToast(String msg) {
        mContext.sh
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

    }
}
