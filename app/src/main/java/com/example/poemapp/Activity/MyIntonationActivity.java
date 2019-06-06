package com.example.poemapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.example.poemapp.R;

public class MyIntonationActivity extends BaseActivity {
    Toolbar myintonationToolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intonation);

        //初始化控件
        initView();
    }


    /**
     * 方法实现
     */
    //初始化控件
    private void initView() {
        //获得控件id
        myintonationToolbar = findViewById(R.id.myintonation_toolbar);

        //功能实现
        setSupportActionBar(myintonationToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("我的朗诵");
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
