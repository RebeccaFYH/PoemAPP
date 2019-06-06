package com.example.poemapp.Fragment;

import android.content.Context;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.renderscript.Sampler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.poemapp.Activity.MainActivity;
import com.example.poemapp.Database.CreateDB;
import com.example.poemapp.JavaClass.CreateCardFJAdapter;
import com.example.poemapp.JavaClass.CreateCardFontAdapter;
import com.example.poemapp.JavaClass.CreateCardPBAdapter;
import com.example.poemapp.JavaClass.CreateCardRWAdapter;
import com.example.poemapp.JavaClass.CreateCardTJAdapter;
import com.example.poemapp.JavaClass.ViewPagerAdapter;
import com.example.poemapp.R;
import com.example.poemapp.ViewModel.CreatePageViewModel;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Created by dell on 2019/3/19.
 */

public class CreatePageFragment extends Fragment {
    //全局声明
    private List<CreateDB> createDBList = new ArrayList<CreateDB>();
    MainActivity mainActivity;
    int N = 58;
    int index;
    String str = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    View view1,view2,view3,tuijianView,fengjingView,renwuView;
    ViewPager viewPager,peituViewPager;
    List<View> viewList,peituViewList;
    List<String> titleList,peituList;
    LayoutInflater inflater;
    TabLayout tabLayout,tabLayout1;
    Context mcontext;
    TextView tipText,yangshiText;
    EditText topicText,contentText;
    ImageButton tipButton;
    Editable topic,content;
    RecyclerView paibanRecyclerView,fontRecyclerView,
            tuijianRecyclerView,fengjingRecyclerView,renwuRecyclerView;

    //UI数据管理对象
    CreatePageViewModel createPageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_create,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity = (MainActivity) getActivity();//获得活动的实例
        mcontext = mainActivity;

        InitDateBase();//初始化数据
        InitView();//初始化控件
        ViewPagerAdapter();//滑块+界面适配器
        RecyclerViewAdapter();//循环视图适配器


        //初始化UI数据管理对象及设置观察者
        createPageViewModel = ViewModelProviders.of((FragmentActivity) mcontext).get(CreatePageViewModel.class);
        createPageViewModel.getEditText().observe((LifecycleOwner) mcontext, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                yangshiText.setText(s);
            }
        });
    }


    /**
     * 方法实现
     */
    //初始化控件
    private void InitView() {
        //获取布局控件id
        tabLayout = getActivity().findViewById(R.id.write_tablayout);
        viewPager = getActivity().findViewById(R.id.write_viewpager);
        inflater = getActivity().getLayoutInflater(); //获得布局对象
        view1 = inflater.inflate(R.layout.tab_chuangzuo,null);
        view2 = inflater.inflate(R.layout.tab_yangshi,null);
        view3 = inflater.inflate(R.layout.tab_peitu,null);

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

        //获取控件id
        //------------------创作
        tipButton = view1.findViewById(R.id.write_tip_button);
        tipText = view1.findViewById(R.id.write_tips_text);
        topicText = view1.findViewById(R.id.topic_editText);
        contentText = view1.findViewById(R.id.content_editText);

        topic = topicText.getText();

        //------------------样式
        yangshiText = view2.findViewById(R.id.yangshi_text);

        //------------------配图
        tabLayout1 = view3.findViewById(R.id.peitu_tablayout);
        peituViewPager = view3.findViewById(R.id.peitu_viewpager);
        tuijianView = inflater.inflate(R.layout.tab_create_peitu_tj,null);
        fengjingView = inflater.inflate(R.layout.tab_create_peitu_fj,null);
        renwuView = inflater.inflate(R.layout.tab_create_peitu_rw,null);

        giveTips();
        submitText();
        setPeituTab();
    }

    //配图界面下的推荐+风景+人物滑块
    private void setPeituTab() {
        //将页面放入列表
        peituViewList = new ArrayList<>();
        peituViewList.add(tuijianView);
        peituViewList.add(fengjingView);
        peituViewList.add(renwuView);
        peituList = new ArrayList<>();
        peituList.add("推荐");
        peituList.add("风景");
        peituList.add("人物");

        //设置tab模式
        tabLayout1.addTab(tabLayout1.newTab().setText(peituList.get(0)));
        tabLayout1.addTab(tabLayout1.newTab().setText(peituList.get(1)));
        tabLayout1.addTab(tabLayout1.newTab().setText(peituList.get(2)));

    }

    //提交创作的文字
    private void submitText() {

        contentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("CreatePageFragment","之前");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("CreatePageFragment","之后");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                content = contentText.getText();
                createPageViewModel.addEditText(content.toString());
            }
        });
    }


    //给灵感相关
    private void giveTips() {
        tipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                Vector<Integer> randInt = new Vector<Integer>();
                int count = 0;
                while(count <4){
                    int randNum = random.nextInt(N)+1;
                    if(!randInt.contains(randNum)){
                        randInt.add(randNum);
                        count++;
                    }

                }

                str = createDBList.get(randInt.get(0)).getCreateTips();
                str1 = createDBList.get(randInt.get(1)).getCreateTips();
                str2 = createDBList.get(randInt.get(2)).getCreateTips();
                str3 = createDBList.get(randInt.get(3)).getCreateTips();

                tipText.setText(str + " "+str1+" "+ str2+" " + str3);

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
                index = position;
                reDrawToolbar();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //配图界面下
        ViewPagerAdapter pagerAdapter1 = new ViewPagerAdapter(peituViewList,peituList);
        peituViewPager.setAdapter(pagerAdapter1);
        tabLayout1.setupWithViewPager(peituViewPager);
        tabLayout1.setTabsFromPagerAdapter(pagerAdapter1);
        peituViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    //RecyclerView适配器
    private void RecyclerViewAdapter() {
        //排版
        paibanRecyclerView = view2.findViewById(R.id.pb_recyclerview);
        paibanRecyclerView.setHasFixedSize(true);
        paibanRecyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        paibanRecyclerView.setLayoutManager(layoutManager);
        CreateCardPBAdapter createCardPBAdapter = new CreateCardPBAdapter(createDBList,mcontext);
        paibanRecyclerView.setAdapter(createCardPBAdapter);

        //字体
        fontRecyclerView = view2.findViewById(R.id.font_recyclerview);
        fontRecyclerView.setHasFixedSize(true);
        fontRecyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager1 = new
                StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        fontRecyclerView.setLayoutManager(layoutManager1);
        CreateCardFontAdapter createCardFontAdapter = new CreateCardFontAdapter(createDBList,mcontext);
        fontRecyclerView.setAdapter(createCardFontAdapter);

        //推荐
        tuijianRecyclerView = tuijianView.findViewById(R.id.tj_recyclerview);
        tuijianRecyclerView.setHasFixedSize(true);
        tuijianRecyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager2 = new
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        tuijianRecyclerView.setLayoutManager(layoutManager2);
        CreateCardTJAdapter createCardTJAdapter = new CreateCardTJAdapter(createDBList,mcontext);
        tuijianRecyclerView.setAdapter(createCardTJAdapter);

        //风景
        fengjingRecyclerView = fengjingView.findViewById(R.id.fj_recyclerview);
        fengjingRecyclerView.setHasFixedSize(true);
        fengjingRecyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager3 = new
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        fengjingRecyclerView.setLayoutManager(layoutManager3);
        CreateCardFJAdapter createCardFJAdapter = new CreateCardFJAdapter(createDBList,mcontext);
        fengjingRecyclerView.setAdapter(createCardFJAdapter);

        //人物
        renwuRecyclerView = renwuView.findViewById(R.id.rw_recyclerview);
        renwuRecyclerView.setHasFixedSize(true);
        renwuRecyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager4 = new
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        renwuRecyclerView.setLayoutManager(layoutManager4);
        CreateCardRWAdapter createCardRWAdapter = new CreateCardRWAdapter(createDBList,mcontext);
        renwuRecyclerView.setAdapter(createCardRWAdapter);

    }

    //临时数据初始化
    public void InitDateBase(){
        createDBList = LitePal.findAll(CreateDB.class);
    }

    //刷新标题栏
    public void reDrawToolbar() {
        mainActivity.setmSwitch(index);
    }

    //监控数据

}
