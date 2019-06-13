package com.example.poemapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;

import com.example.poemapp.Adapter.NavMyIntonationAdapter;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MyIntonationActivity extends BaseActivity {
    List<PostDB> postDBList = new ArrayList<PostDB>();
    Toolbar myintonationToolbar;
    ActionBar actionBar;
    RecyclerView navmyinnovationRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intonation);

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
        navmyinnovationRecyclerView = findViewById(R.id.intonationo_title);
        myintonationToolbar = findViewById(R.id.myintonation_toolbar);

        //功能实现
        setSupportActionBar(myintonationToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("我的朗诵");
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        navinnovationView();
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
    private void navinnovationView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        navmyinnovationRecyclerView.setLayoutManager(linearLayoutManager);

        NavMyIntonationAdapter navMyIntonationAdapter = new NavMyIntonationAdapter(postDBList,MyIntonationActivity.this);
        navmyinnovationRecyclerView.setAdapter( navMyIntonationAdapter);
    }

    //初始化数据库
    private void initDataBase(){
        postDBList = LitePal.findAll(PostDB.class);
    }
}
