package com.example.poemapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.poemapp.InitData.InitCommuicateFunDB;
import com.example.poemapp.InitData.InitCreateDB;
import com.example.poemapp.InitData.InitPoemDB;
import com.example.poemapp.InitData.InitPostDB;
import com.example.poemapp.InitData.InitWriterDB;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {
    //全局声明
    private TextView tv;
    private Boolean A = true;
    private Timer timer = new Timer();
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        LitePal.getDatabase();
        SharedPreferences sharedPreferences=this.getSharedPreferences("share",MODE_PRIVATE);
        boolean isFirstRun=sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor=sharedPreferences.edit();


        //判断是否第一次打开app
        if(isFirstRun){
            editor.putBoolean("isFirstRun", true);
            editor.commit();

            try {
                InitPoemDB initPoemDB = new InitPoemDB(this);
                InitWriterDB initWriterDB = new InitWriterDB(this);
                InitPostDB initPostDB = new InitPostDB(this);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //调用控件
        initView();

        //倒计时
        tv = findViewById(R.id.through_text);

        //倒计时实现
        timer.schedule(new TimerTask() {
            @Override
            public void run () {
                if (A == true) {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);
    }

    /**
     * 方法实现
     */
    //控件实现
    public void initView(){
        //获取控件ID
        button1 = (Button) findViewById(R.id.through);

        //点击事件
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        A = false;
    }

}


