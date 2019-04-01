package com.example.jsoup;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jsoup.view.LoadingPager;
import com.trello.rxlifecycle3.components.support.RxFragment;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {

    protected Unbinder mUnbinder;
    protected Context mContext;
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
//        return super.onCreateView(inflater, container, savedInstanceState);

//        //错误示范
//        mRootView = inflater?.inflate(R.layout.fragment_doemstic_city, container)
//        //正确写法
//        mRootView = inflater?.inflate(R.layout.fragment_doemstic_city, null)
//        mRootView = inflater?.inflate(R.layout.fragment_doemstic_city, container,false)
//        View rootView = inflater.inflate(getlayout(),null);
        View rootView = inflater.inflate(getlayout(),container,false);
        mUnbinder = ButterKnife.bind(rootView);
        return rootView;
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
}
