package com.example.jsoup.factory;

import com.example.jsoup.BaseFragment;
import com.example.jsoup.fragment.HomeFragment;
import com.example.jsoup.fragment.Tab1Fragment;
import com.example.jsoup.fragment.Tab2Fragment;
import com.example.jsoup.fragment.Tab3Fragment;
import com.example.jsoup.fragment.Tab4Fragment;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;

/**
 * @author
 * @description:
 * @date :2019/3/30 9:40
 */
public class FragmentFactory {
    public static final int TAB_FRAGMENT_0 = 0;
    public static final int TAB_FRAGMENT_1 = 1;
    public static final int TAB_FRAGMENT_2 = 2;
    public static final int TAB_FRAGMENT_3 = 3;
    public static final int TAB_FRAGMENT_4 = 4;
    public static Map<Integer,BaseFragment> sFragmentMap = new HashMap<>();
    private static Fragment mCurrentFragment;




    public static Fragment creatFragment(int index){
        mCurrentFragment = sFragmentMap.get(index);
        if (mCurrentFragment!=null) return mCurrentFragment ;
        switch (index){
            case TAB_FRAGMENT_0:
                mCurrentFragment =new HomeFragment();
                break;
            case TAB_FRAGMENT_1:
                mCurrentFragment =new Tab1Fragment();
                break;
            case TAB_FRAGMENT_2:
                mCurrentFragment =new Tab2Fragment();
                break;
            case TAB_FRAGMENT_3:
                mCurrentFragment =new Tab3Fragment();
                break;
            case TAB_FRAGMENT_4:
                mCurrentFragment =new Tab4Fragment();
                break;
        }
        return  mCurrentFragment;
    }
}
