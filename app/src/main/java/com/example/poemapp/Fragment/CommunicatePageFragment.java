package com.example.poemapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.poemapp.Activity.MainActivity;
import com.example.poemapp.Database.CommunicateFunDB;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.Adapter.CommunicateCardFriendAdapter;
import com.example.poemapp.Adapter.CommunicateCardFunAdapter;
import com.example.poemapp.Adapter.ViewPagerAdapter;
import com.example.poemapp.R;
import com.google.android.material.tabs.TabLayout;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/3/19.
 */

public class CommunicatePageFragment extends Fragment {
    //全局声明
    private List<PostDB> postDBList = new ArrayList<PostDB>();
    private List<CommunicateFunDB> communicateFunDBList = new ArrayList<CommunicateFunDB>();
    List<View> viewList;
    List<String> titleList,leixingList,paixuList;
    View view1,view2;
    ViewPager viewPager;
    LayoutInflater inflater;
    TabLayout tabLayout;
    Context mcontext;
    RecyclerView recyclerView,recyclerView1;
    Spinner spinner1,spinner2;
    ArrayAdapter<String> arrayAdapter1,arrayAdapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_communicate,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        InitDateBase();
        initView();
        ViewPagerAdapter();
        PubuliuAdapter();
    }


    /**
     * 方法声明
     */
    //控件初始化
    private void initView() {
        //获取控件id
        tabLayout = getActivity().findViewById(R.id.communicate_tablayout);
        viewPager = getActivity().findViewById(R.id.communicate_viewpager);
        inflater = getActivity().getLayoutInflater();  //获得布局对象
        view1 = inflater.inflate(R.layout.card_communicate_friend,null);
        view2 = inflater.inflate(R.layout.card_communicate_fun,null);

        //获取活动
        MainActivity mainActivity = (MainActivity) getActivity();
        mcontext = mainActivity;

        //将页面放入列表
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        titleList = new ArrayList<>();
        titleList.add("诗友圈");
        titleList.add("诗乐园");

        //设置tab模式
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));

        //调用
        initSpinner();  //下拉列表框

    }
    //下拉列表框
    private void initSpinner() {
        //类型
        spinner1 = view2.findViewById(R.id.communicate_fun_leixing);
        leixingList = new ArrayList<String>();
        leixingList.add("全部游戏");
        leixingList.add("诗词接龙");
        leixingList.add("曲水流觞");
        leixingList.add("对对子");
        arrayAdapter1 = new ArrayAdapter<String>(mcontext,
                R.layout.support_simple_spinner_dropdown_item,leixingList);
        spinner1.setAdapter(arrayAdapter1);
        //排序
        spinner2 = view2.findViewById(R.id.communicate_fun_paixu);
        paixuList = new ArrayList<String>();
        paixuList.add("最新发布");
        paixuList.add("参与人数");
        paixuList.add("收藏最多");
        paixuList.add("评论最多");
        arrayAdapter2 = new ArrayAdapter<String>(mcontext,
                R.layout.support_simple_spinner_dropdown_item,paixuList);
        spinner2.setAdapter(arrayAdapter2);
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

    //瀑布流布局适配器
    public void PubuliuAdapter(){
        //诗友圈
        recyclerView = view1.findViewById(R.id.rv_communicate_friend);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext);
        recyclerView.setLayoutManager(layoutManager);
        CommunicateCardFriendAdapter adapter1 = new CommunicateCardFriendAdapter(postDBList, mcontext);
        recyclerView.setAdapter(adapter1);

        //诗乐园
        recyclerView1 = view2.findViewById(R.id.rv_communicate_fun);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(mcontext);
        recyclerView1.setLayoutManager(layoutManager1);
        CommunicateCardFunAdapter adapter2 = new CommunicateCardFunAdapter(communicateFunDBList,mcontext);
        recyclerView1.setAdapter(adapter2);
    }

    //数据初始化
    private void InitDateBase() {
        postDBList = LitePal.findAll(PostDB.class);
        communicateFunDBList = LitePal.findAll(CommunicateFunDB.class);

    }

}
