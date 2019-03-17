package com.example.poemapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.example.poemapp.JavaClass.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StudyPageActivity extends BaseActivity {
    //全局声明
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    View view1,view2;
    ViewPager viewPager;
    List<View> viewList;
    List<String> titleList;
    LayoutInflater inflater;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_page);

        //调用控件
        initView();
        allAdapter();

    }

    /**
     * 方法实现
     */
    //控件实现
    public void initView(){
        //获取控件id
        toolbar = findViewById(R.id.study_toolbar);
        drawerLayout = findViewById(R.id.study_drawerlayout);
        tabLayout = findViewById(R.id.study_tablayout);
        viewPager = findViewById(R.id.study_viewpager);
        inflater = getLayoutInflater();  //获得布局对象
        view1 = inflater.inflate(R.layout.tab_tuijian,null);
        view2 = inflater.inflate(R.layout.tab_minivideo,null);

        //功能
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_menu);
        }

        //将页面放入列表
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        titleList = new ArrayList<>();
        titleList.add("推荐");
        titleList.add("微课堂");

        //设置tab模式
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

    //适配器
    public void allAdapter(){
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(viewList,titleList);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }






}
