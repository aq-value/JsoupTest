package com.example.jsoup.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jsoup.BaseFragment;
import com.example.jsoup.BaseFragmentLoading;
import com.example.jsoup.R;

import androidx.annotation.Nullable;

/**
 * @author liu
 * @description:
 * @date :2019/4/1 11:29
 */
public class Tab1Fragment extends BaseFragmentLoading {
    @Override
    protected void initData() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected View cretaeSuccessView() {
        return null;
    }

    @Override
    protected void load() {

    }
}
