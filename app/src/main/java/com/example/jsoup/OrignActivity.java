package com.example.jsoup;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.jsoup.aadaggertest.DaggerActivity;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/4/2
 * Time: 11:11
 */
public class OrignActivity extends BaseActivity {
    @BindView(R.id.orign_lv)
    ListView mListView;


    private List<String> mActivities =new ArrayList<>();
    private List<Map<String, Object>> mDatas = new ArrayList<>();
    @Override
    protected void initData() {
        mDatas.add( new HashMap<String, Object>(){
            {
                put("Ac","MainActivity");
                put("id",1);
            }
        });
        mDatas.add( new HashMap<String, Object>(){
            {
                put("Ac","DaggerActivity");
                put("id",2);
            }
        });
        mListView.setAdapter(new SimpleAdapter(this,mDatas,android.R.layout.simple_list_item_2,
                new String[]{"Ac","id"},new int[]{android.R.id.text2,android.R.id.text1}));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lv = (ListView) parent;
                Map <String,Object> map = (Map<String, Object>) lv.getItemAtPosition(position);

                String ss = (String) map.get("Ac");
                Intent intent;
                switch (ss){
                    case "DaggerActivity":
                        intent = new Intent(OrignActivity.this, DaggerActivity.class);
                        break;
                    case "MainActivity":
                        intent = new Intent(OrignActivity.this, MainActivity.class);
                        break;
                    default:
                        intent = new Intent(OrignActivity.this,OrignActivity.class);
                }
                startActivity(intent);
            }
        });
     }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_orign;
    }


}
