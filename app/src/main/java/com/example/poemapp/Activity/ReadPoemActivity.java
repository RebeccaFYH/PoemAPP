package com.example.poemapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.poemapp.Database.PoemDB;

import com.example.poemapp.Database.WriterDB;
import com.example.poemapp.R;
import com.gcssloop.widget.RCRelativeLayout;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ReadPoemActivity extends BaseActivity {

    //数据库数据获取
    private List<PoemDB> poemList = new ArrayList<PoemDB>();
    private List<WriterDB> writerList = new ArrayList<WriterDB>();
    PoemDB poemInformation = new PoemDB();
    WriterDB writerInformation = new WriterDB();

    //功能性控件声明
    Button closeButton;
    Button bjButton,zsButton,ywButton,sxButton,tsButton;
    RCRelativeLayout bjR,zsR,ywR,sxR,tsR;
    Toolbar toolbar;
    ActionBar actionBar;
    FrameLayout frameLayout;
    FrameLayout frameMainLayout;
    TextView poemTextview;
    TextView detailTextview;
    TextView poemnameTextview;
    Boolean isDetail;   //标记是否处于学习状态（下方学习按钮有没有被点击），由于调试正文文本框高度

    /////
    String oldText,newText;
    String oldDText,newDText;
    int id;
    String poemName,text;
    ////

    //控制量
    FrameLayout.LayoutParams layoutParams;
    DisplayMetrics metrics = new DisplayMetrics();
    int width;
    int height;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        id = bundle.getInt("poemId");

        setContentView(R.layout.activity_read_poem);

        //调用方法
        InitDatabase();
        initView();
        setTitleBar();
        buttomBtOnClick();
        LearnBtOnclick();

    }

    /**
     * 方法实现
     */
    //设置标题栏
    private void setTitleBar() {
        //顶端标题
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }

    }

    //初始化控件
    private void initView() {
        //获取控件id
        toolbar = findViewById(R.id.study_toolbar);
        closeButton = findViewById(R.id.readpoem_setbgclose);
        frameLayout = findViewById(R.id.readpoem_setbg);
        frameMainLayout = findViewById(R.id.readpoem_layout);
        poemTextview = findViewById(R.id.readpoem_content);
        detailTextview=findViewById(R.id.readpoem_detail);
        poemnameTextview=findViewById(R.id.title_read);
        isDetail=false;

        //将读取的数据中的空格替换为换行符，赋予文本框
        poemName = poemInformation.getPoemName();
        oldText = poemInformation.getPoemContent();
        newText = oldText.replace(' ','\n');
        poemnameTextview.setText(poemName);
        poemTextview.setText(newText);
        poemnameTextview.setGravity(Gravity.CENTER);

        //底部按钮
        bjButton=findViewById(R.id.bt_bj);
        zsButton=findViewById(R.id.bt_zs);
        ywButton=findViewById(R.id.bt_yw);
        sxButton=findViewById(R.id.bt_sx);
        tsButton=findViewById(R.id.bt_ts);
        bjR=findViewById(R.id.bt_bj_all);
        zsR=findViewById(R.id.bt_zs_all);
        ywR=findViewById(R.id.bt_yw_all);
        sxR=findViewById(R.id.bt_sx_all);
        tsR=findViewById(R.id.bt_ts_all);

        //获得屏幕分辨率
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);//屏幕适配分辨率

        //方法实现
        poemTextview.setMovementMethod(ScrollingMovementMethod.getInstance());//文本可滑动显示
        detailTextview.setMovementMethod(ScrollingMovementMethod.getInstance());

    }

    //初始化加载数据
    private void InitDatabase(){
        poemList=LitePal.findAll(PoemDB.class);
        poemInformation=poemList.get(id);

//        writerList = LitePal.findAll(WriterDB.class);
//        writerInformation = writerList.get(id);
    }

    //按钮监听
    private void buttomBtOnClick() {
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutParams.width = width;
                layoutParams.height = height;
                setLearnBtBg(bjR,false);
                //layoutParams.setMargins(20,200,20,300);
                //textView.setLayoutParams(layoutParams);
                frameLayout.setVisibility(View.GONE);
                poemTextview.setHeight(poemTextview.getHeight()*2);
                isDetail=false;

            }
        });

    }
    private void LearnBtOnclick(){
        bjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLearnBtBg(bjR,true);
                setDetailText(bjR);
//                setFragment();
//                replaceFragment(new PoemReadBJFragment());
            }
        });
        zsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLearnBtBg(zsR,true);
                setDetailText(zsR);
//                setFragment();
//                replaceFragment(new PoemReadZSFragment());
            }
        });
        ywButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLearnBtBg(ywR,true);
                setDetailText(ywR);
//                setFragment();
//                replaceFragment(new PoemReadYWFragment());
            }
        });
        sxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLearnBtBg(sxR,true);
                setDetailText(sxR);
//                setFragment();
//                replaceFragment(new PoemReadSXFragment());
            }
        });
        tsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLearnBtBg(tsR,true);
                setDetailText(tsR);
//                setFragment();
//                replaceFragment(new PoemReadTSFragment());
            }
        });
    }

    //设置学习按钮状态（背景的圆圈）
    private void setLearnBtBg(RCRelativeLayout selectedBt,boolean learn){
        bjR.setStrokeWidth(0);
        zsR.setStrokeWidth(0);
        ywR.setStrokeWidth(0);
        sxR.setStrokeWidth(0);
        tsR.setStrokeWidth(0);

        if(learn){
            selectedBt.setStrokeWidth(10);
            selectedBt.setStrokeColor(R.color.black_bt);
        }
    }

    private void setDetailText(RCRelativeLayout selectedBt){

        if(isDetail==false) {
            poemTextview.setHeight(poemTextview.getHeight()/2);
            isDetail=true;
        }
        frameLayout.setVisibility(View.VISIBLE);

        if(selectedBt==bjR){
            oldDText=poemInformation.getPoemCreateBackgrond();
        }else if (selectedBt==zsR){
            oldDText=poemInformation.getPoemZhushi();
        }else if (selectedBt==ywR){
            oldDText=poemInformation.getPoemTranslation();
        }else if (selectedBt==sxR){
            oldDText=poemInformation.getPoemAppreciation();
        }else if (selectedBt==tsR){
            oldDText=poemInformation.getPoemFYRadioPath();
        }

        newDText=oldDText.replace(' ','\n');
        detailTextview.setText(newDText);
    }

    //设置fragment出现后正文部分的布局
    private void setFragment(){
        //layoutParams.width = (width*1);
        //layoutParams.height = (int)(height*0.5);
        //layoutParams.setMargins(20,200,20,20);
        //textView.setLayoutParams(layoutParams);
        if(isDetail==false) {
            poemTextview.setHeight(poemTextview.getHeight()/2);
            isDetail=true;
        }
        frameLayout.setVisibility(View.VISIBLE);

    }

    //fragment切换
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   //开启转换事务
        //transaction.replace(R.id.readpoem_setbg,fragment);
        //transaction.commit();   //提交并结束事务
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
