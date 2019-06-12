package com.example.poemapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;

import com.example.poemapp.Adapter.NavMsgFriendsAdapter;
import com.example.poemapp.Adapter.NavPeoFriendsAdapter;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendActivity extends BaseActivity {
    List<PostDB> postDBList = new ArrayList<PostDB>();
    Toolbar friendToolbar;
    ActionBar actionBar;
    RecyclerView navpeofriendsRecyclerView;

    //获得数据


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        //数据初始化
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
        friendToolbar = findViewById(R.id.friend_toolbar);
        navpeofriendsRecyclerView = findViewById(R.id.navpeo_friends);

        //功能实现
        setSupportActionBar(friendToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("诗友名册");
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        navPeoFriView();
    }

    //循环列表
    private void navPeoFriView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        navpeofriendsRecyclerView.setLayoutManager(linearLayoutManager);
        NavMsgFriendsAdapter navMsgFriendsAdapter = new NavMsgFriendsAdapter(postDBList,FriendActivity.this);
        navpeofriendsRecyclerView.setAdapter( navMsgFriendsAdapter);
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

    //初始化数据库
        private void initDataBase() {
            postDBList = LitePal.findAll(PostDB.class);
    }

}
