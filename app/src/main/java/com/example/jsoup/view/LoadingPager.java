package com.example.jsoup.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.jsoup.R;
import com.example.jsoup.utils.UIUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/1
 * Time: 16:04
 */
public abstract class LoadingPager extends FrameLayout {
    /**
     * 默认状态
     */
    public final static int STATE_UNKONW = 0;

    /**
     * 加载中的状态
     */
    public final static int STATE_LOADING = 1;

    /**
     * 加载失败状态
     */
    public final static int STATE_ERROR = 2;

    /**
     * 加载成功状态
     */
    public final static int STATE_SUCCESS = 3;

    /**
     * 加载空状态（无数据状态）
     */
    public final static int STATE_EMPTY = 4;

    public LoadingPager(@NonNull Context context) {
        super(context);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }



    //.........
    private View loadingView;
    private View errorView;
    private View successView;
    private View emptyView;
    private int state = STATE_UNKONW;

    private void init() {
        if (loadingView == null) {
            loadingView = createLoadingView();
            this.addView(loadingView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        }
        if (errorView == null) {
            errorView = createErrorView();
            this.addView(errorView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        }
        if (emptyView == null) {
            emptyView = createEmptyView();
            this.addView(emptyView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        }

        showPager();
    }

    /**
     * 请求网络 修改状态
     */
    public void show() {
        if (state == STATE_UNKONW || state == STATE_ERROR || state == STATE_EMPTY) {
            state = STATE_LOADING;
            load();
        }
        showPager();
    }

    /**
     * 设置状态
     *
     * @param result
     */
    public void setState(LoadResult result) {
        state = result.getValue();
        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showPager();
            }
        });
    }

    /**
     * 请求结果的枚举
     */
    public enum LoadResult {
        error(STATE_ERROR), success(STATE_SUCCESS), empty(STATE_EMPTY);

        int value;

        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 根据不同的状态显示不同的布局
     */
    private void showPager() {
        if (loadingView != null) {
            loadingView.setVisibility(state == STATE_LOADING || state == STATE_UNKONW ? View.VISIBLE : View.GONE);
        }
        if (errorView != null) {
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.GONE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.GONE);
        }
        if (successView == null && state == STATE_SUCCESS) {
            successView = cretaeSuccessView();
            this.addView(successView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        }
    }

    private View createLoadingView() {
//        return View.inflate(R.layout.utils.loading_page);
        return UIUtils.inflate(R.layout.layout1);
    }

    private View createEmptyView() {
        return UIUtils.inflate(R.layout.loading_page_empty);
    }

    private View createErrorView() {
        View view = UIUtils.inflate(R.layout.loading_error_page);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return view;
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
}
