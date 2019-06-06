package com.example.poemapp.Activity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.example.poemapp.R;

public class IndexActivity extends BaseActivity {
    Toolbar indexToolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //初始化控件
        initView();
    }

    /**
     * 方法实现
     */
    //初始化控件
    private void initView() {
        //获得控件id
        indexToolbar = findViewById(R.id.index_toolbar);

        //功能实现
        setSupportActionBar(indexToolbar);
        actionBar = getSupportActionBar();//获得自定义标题栏
        actionBar.setTitle("诗词索引");
        //设置返回按钮
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
