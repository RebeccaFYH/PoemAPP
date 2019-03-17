package com.example.poemapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {
    //全局声明
    private TextView tv;
    private Boolean A = true;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //调用控件
        initView();

        //倒计时
        tv = findViewById(R.id.through_text);

        //倒计时实现
        timer.schedule(new TimerTask() {
            @Override
            public void run () {
                if (A == true) {
                    Intent intent = new Intent(WelcomeActivity.this, StudyPageActivity.class);
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
        Button button1 = (Button) findViewById(R.id.through);

        //点击事件
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,StudyPageActivity.class);
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


