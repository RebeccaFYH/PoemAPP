package com.example.poemapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;

import com.example.poemapp.Adapter.NavMsgFriendsAdapter;
import com.example.poemapp.Adapter.NavMyWorksAdapter;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

public class MyWorksActivity extends BaseActivity{

    List<PostDB> postDBList = new ArrayList<PostDB>();
    Toolbar myworksToolbar;
    ActionBar actionBar;
    RecyclerView navmyworksRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_works);

        initDataBase();
        //初始化控件
        initView();
    }


    /**
     * 方法实现
     */
    //初始化控件
    private void initView() {
        //获得控件id
        myworksToolbar = findViewById(R.id.myworks_toolbar);
        navmyworksRecyclerView = findViewById(R.id.nav_myworks);

        //功能实现
        setSupportActionBar(myworksToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("我的作品");
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        navMyWorksView();
    }

    //循环列表
    private void navMyWorksView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        navmyworksRecyclerView.setLayoutManager(linearLayoutManager);
        NavMyWorksAdapter navMyWorksAdapter = new NavMyWorksAdapter(postDBList,MyWorksActivity.this);
        navmyworksRecyclerView.setAdapter(navMyWorksAdapter);
    }
    //初始化数据库
    private void initDataBase(){
        postDBList = LitePal.findAll(PostDB.class);
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
