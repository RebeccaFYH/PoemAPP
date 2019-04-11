package com.example.poemapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;


import com.example.poemapp.Fragment.CommunicatePageFragment;
import com.example.poemapp.Fragment.FunPageFragment;
import com.example.poemapp.Fragment.StudyPageFragment;
import com.example.poemapp.Fragment.WritePageFragment;
import com.example.poemapp.InitData.InitPoemDB;
import com.example.poemapp.JavaClass.BottomNavigationViewHelper;
import com.example.poemapp.R;

import java.io.IOException;


public class MainActivity extends BaseActivity {
    //全局声明
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        replaceFragment(new StudyPageFragment());


        //调用控件
        initView();

    }



    /**
     * 方法实现
     */
    //控件实现
    public void initView(){
        //获取控件id
        toolbar = findViewById(R.id.study_toolbar);
        drawerLayout = findViewById(R.id.study_drawerlayout);

        //顶端标题
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_menu);
        }

        //底端按钮
        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {   //监听器
                switch (item.getItemId()){
                    case R.id.bt_study:
                        replaceFragment(new StudyPageFragment());
                        break;
                    case R.id.bt_write:
                        replaceFragment(new WritePageFragment());
                        break;
                    case R.id.bt_shequ:
                        replaceFragment(new CommunicatePageFragment());
                        break;
                    case R.id.bt_fun:
                        replaceFragment(new FunPageFragment());
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


    //点击item
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.search:
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    //fragment切换
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   //开启转换事务
        transaction.replace(R.id.main_layout,fragment);
        transaction.commit();   //提交并结束事务
    }



}
