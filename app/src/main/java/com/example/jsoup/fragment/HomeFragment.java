package com.example.jsoup.fragment;

import android.util.Log;

import com.example.jsoup.BaseFragment;
import com.example.jsoup.entry.JsoupEntry.JsoupBean;
import com.example.jsoup.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author liu
 * @description:
 * @date :2019/4/1 11:29
 */
public class HomeFragment extends BaseFragment{

    @BindView(R.id.fragment_home_rc)
    RecyclerView mRecyclerView;


    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getjsoupData();
            }
        }).start();
    }

    private void getjsoupData() {
        String url = "http://www.jcodecraeer.com";
        try {
            Document document = Jsoup.connect(url).get();
            JsoupBean jsoupBean = new JsoupBean();
            jsoupBean.setLogoImg(url+document.select("a.logo-t>img").attr("src"));//select的api的详细用法请查看官方文档
            jsoupBean.setLogoUrl(url);
            jsoupBean.setLogoName(document.select("a.logo-t").text());
            Log.e("temp","jsoupBean="+jsoupBean.toString());

        }catch ( Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment_home;
    }

}
