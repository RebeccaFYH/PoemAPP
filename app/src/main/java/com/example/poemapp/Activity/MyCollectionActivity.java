package com.example.poemapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;

import com.example.poemapp.Adapter.NavCollectionAdapter;
import com.example.poemapp.Database.CollectRelativeDB;
import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCollectionActivity extends BaseActivity {

    List<CollectRelativeDB> collectRelativeDBList = new ArrayList<CollectRelativeDB>();
    List<PoemDB> poemDBList = new ArrayList<PoemDB>();
    Toolbar mycollectionToolbar;
    ActionBar actionBar;


    RecyclerView navcollectionRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);

        initCollectData();
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
        navcollectionRecyclerView = findViewById(R.id.collection_poem);

        //功能实现
        setSupportActionBar(mycollectionToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("我的收藏");
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        navCollectionView();//循环列表
    }
    //循环列表
    private void navCollectionView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        navcollectionRecyclerView.setLayoutManager(linearLayoutManager);
        NavCollectionAdapter navCollectionAdapter = new NavCollectionAdapter(poemDBList,MyCollectionActivity.this);
        navcollectionRecyclerView.setAdapter(navCollectionAdapter);
    }


    private void initCollectData(){
        poemDBList = LitePal.where("isCollect = ?", "true")
                .order("poemID").find(PoemDB.class);

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
