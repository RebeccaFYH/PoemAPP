package com.example.poemapp.Activity;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.poemapp.R;

/**
 * Created by dell on 2019/3/27.
 */

public class SearchActivity extends BaseActivity {
    Toolbar searchToolbar;
    SearchView searchView;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //初始化控件
        initView();
    }

    /**
     * 方法实现
     */
    //初始化控件
    private void initView(){
        //获取控件id
        searchToolbar = findViewById(R.id.search_toolbar);
        searchView = findViewById(R.id.app_bar_search);

        //功能实现
        setSupportActionBar(searchToolbar); //标题栏
        //searchView.setIconifiedByDefault(false);  //默认展开搜索框
        //searchView.setQueryHint("输入搜索内容");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_search,menu);
        return true;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
