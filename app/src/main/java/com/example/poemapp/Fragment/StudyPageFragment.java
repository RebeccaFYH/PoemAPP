package com.example.poemapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.JavaClass.StudyCardWriterAdapter;
import com.example.poemapp.JavaClass.ViewPagerAdapter;
import com.example.poemapp.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/3/18.
 */

public class StudyPageFragment extends Fragment {
    //全局声明
    private List<PoemDB> poemDBList = new ArrayList<PoemDB>();
    View view1,view2;
    ViewPager viewPager;
    List<View> viewList;
    List<String> titleList;
    LayoutInflater inflater;
    TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_study,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        InitDateBase();
        InitView();
        ViewPagerAdapter();
        PubuliuAdapter();

    }

    /**
     * 功能实现
     */

    //初始化界面
    private void InitView(){
        //获取控件id
        tabLayout = getActivity().findViewById(R.id.study_tablayout);
        viewPager = getActivity().findViewById(R.id.study_viewpager);
        inflater = getLayoutInflater();  //获得布局对象
        view1 = inflater.inflate(R.layout.tab_tuijian,null);
        view2 = inflater.inflate(R.layout.tab_minivideo,null);

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

    //滑块+界面适配器
    public void ViewPagerAdapter(){
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

    //瀑布流布局适配器去
    public void PubuliuAdapter(){
        RecyclerView recyclerView = view1.findViewById(R.id.study_recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        StudyCardWriterAdapter adapter = new StudyCardWriterAdapter(poemDBList);
        recyclerView.setAdapter(adapter);
    }

    //临时数据初始化
    public void InitDateBase(){
        poemDBList = LitePal.findAll(PoemDB.class);

    }

}
