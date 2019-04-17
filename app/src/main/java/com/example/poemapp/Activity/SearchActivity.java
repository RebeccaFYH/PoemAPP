package com.example.poemapp.Activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
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
    ActionBar actionBar;

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

        //功能实现
        setSupportActionBar(searchToolbar); //标题栏
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_search,menu);
        menuItem = menu.findItem(R.id.app_bar_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconifiedByDefault(false);  //默认展开搜索框
        searchView.setQueryHint("输入搜索内容");
        return true;
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

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
