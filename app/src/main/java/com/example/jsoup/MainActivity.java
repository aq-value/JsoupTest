package com.example.jsoup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import com.example.jsoup.adapter.FixPageAdapter;
import com.example.jsoup.factory.FragmentFactory;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_bt)
    Button mButton;
    @BindView(R.id.main_tl)
    TabLayout mTabLayout;
    @BindView(R.id.main_vp)
    ViewPager mViewPager;


    private List<String> mTitles = new ArrayList<>();
    private List<String> mTitles2 = Arrays.asList("0","1","2","3","4");
    private List<Fragment> mFragments = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }
    @Override
    protected void initView() {
        mButton.setText("ces");
    }
    @Override
    protected void initData() {
        FixPageAdapter fixPageAdapter = new FixPageAdapter(this.getSupportFragmentManager());

        for (int i = 0;i<mTitles2.size();i++){
            mFragments.add(FragmentFactory.creatFragment(i));
        }
        fixPageAdapter.setTitles(mTitles2);
        fixPageAdapter.setFragments(mFragments);
        mViewPager.setAdapter(fixPageAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                showTheFragment( position);
            }

            @Override
            public void onPageSelected(int position) {
                showTheFragment( position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showTheFragment(int position) {
        Fragment baseFragment =FragmentFactory.creatFragment(position);
//        baseFragment.show();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
