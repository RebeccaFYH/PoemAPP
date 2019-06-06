package com.example.poemapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.example.poemapp.R;

public class FriendActivity extends BaseActivity {
    Toolbar friendToolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

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

        //功能实现
        setSupportActionBar(friendToolbar); //标题栏
        actionBar = getSupportActionBar();
        actionBar.setTitle("诗友名册");
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
