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
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.InitData.InitPostDB;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends BaseActivity {
    List<PostDB> postDBList = new ArrayList<PostDB>();
    Toolbar msgToolbar;
    ActionBar actionBar;
    RecyclerView navmsgfriendsRecyclerView;


    //控制量


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        //初始化数据
        try {
            initDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //初始化控件
        initView();
    }


    /**
     * 方法实现
     */
    //初始化控件
    private void initView() {
        //获得控件id
        msgToolbar = findViewById(R.id.msg_toolbar);
        navmsgfriendsRecyclerView = findViewById(R.id.navmsg_friend);
        //功能实现
        setSupportActionBar(msgToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("信笺");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        navMsgFriView();//navfrimsg循环列表
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;

    }

    //循环列表
    private void navMsgFriView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        navmsgfriendsRecyclerView.setLayoutManager(linearLayoutManager);
        NavMsgFriendsAdapter navMsgFriendsAdapter = new NavMsgFriendsAdapter(postDBList,MsgActivity.this);
        navmsgfriendsRecyclerView.setAdapter(navMsgFriendsAdapter);
    }
    //初始化数据库
    private void initDataBase() throws IOException {
        postDBList = LitePal.findAll(PostDB.class);
    }

}
