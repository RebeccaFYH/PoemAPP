package com.example.poemapp.Fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.poemapp.Activity.MainActivity;
import com.example.poemapp.JavaClass.ViewPagerAdapter;
import com.example.poemapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/3/19.
 */

public class CreatePageFragment extends Fragment {
    //全局声明
    View view1,view2,view3;
    ViewPager viewPager;
    List<View> viewList;
    List<String> titleList;
    LayoutInflater inflater;
    TabLayout tabLayout;
    Context mcontext;
    TextView tipText;
    EditText topicText;
    EditText contentText;
    ImageButton tipButton;
    String topic;
    String content;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_write,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        InitView();//初始化控件
        ViewPagerAdapter();//滑块+界面适配器
    }

    /**
     * 方法实现
     */
    //初始化控件
    private void InitView() {
        //获取布局控件id
        tabLayout = getActivity().findViewById(R.id.write_tablayout);
        viewPager = getActivity().findViewById(R.id.write_viewpager);
        inflater = getActivity().getLayoutInflater();  //获得布局对象
        view1 = inflater.inflate(R.layout.tab_chuangzuo,null);
        view2 = inflater.inflate(R.layout.tab_yangshi,null);
        view3 = inflater.inflate(R.layout.tab_peitu,null);

        //获取控件id
        //------------------创作
        tipButton = view1.findViewById(R.id.write_tip_button);
        tipText = view1.findViewById(R.id.write_tips_text);
        contentText = view1.findViewById(R.id.topic_editText);
        topicText = view1.findViewById(R.id.content_editText);
        content = contentText.getText().toString();
        topic = topicText.getText().toString();
        sendContentMsg(content,topic);//传递创作的文字信息

        //获取活动
        MainActivity mainActivity = (MainActivity) getActivity();
        mcontext = mainActivity;

        //将页面放入列表
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        titleList = new ArrayList<>();
        titleList.add("创作");
        titleList.add("样式");
        titleList.add("配图");

        //设置tab模式
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));

        giveTips();

    }

    //传递创作的文字信息
    private void sendContentMsg(String content,String topic) {

    }

    //给灵感相关
    private void giveTips() {
        tipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipText.setVisibility(View.VISIBLE);
            }
        });
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

    //保存此活动状态
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
