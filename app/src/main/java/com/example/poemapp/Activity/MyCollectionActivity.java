package com.example.poemapp.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.poemapp.R;

public class MyCollectionActivity extends BaseActivity {
    Toolbar mycollectionToolbar;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);

        //初始化控件
        initView();
    }


    /**
     * 方法实现
     */
    //初始化控件
    private void initView() {
        //获得控件id
        mycollectionToolbar = findViewById(R.id.mycollection_toolbar);

        //功能实现
        setSupportActionBar(mycollectionToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("我的收藏");
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
