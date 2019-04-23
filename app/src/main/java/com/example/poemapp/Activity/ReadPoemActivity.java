package com.example.poemapp.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.poemapp.Fragment.PoemReadBJFragment;
import com.example.poemapp.Fragment.PoemReadSXFragment;
import com.example.poemapp.Fragment.PoemReadTSFragment;
import com.example.poemapp.Fragment.PoemReadYWFragment;
import com.example.poemapp.Fragment.PoemReadZSFragment;
import com.example.poemapp.JavaClass.BottomNavigationViewHelper;
import com.example.poemapp.R;

public class ReadPoemActivity extends AppCompatActivity {
    //功能性控件声明
    Button closeButton;
    Toolbar toolbar;
    ActionBar actionBar;
    FrameLayout frameLayout;
    FrameLayout frameMainLayout;
    TextView textView;

    //控制量
    FrameLayout.LayoutParams layoutParams;
    DisplayMetrics metrics = new DisplayMetrics();
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_read_poem);

        //调用方法
        initView();
        setTitleBar();
        buttomBtOnClick();

    }

    /**
     * 方法实现
     */
    //设置标题栏
    private void setTitleBar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        actionBar.setTitle("诗词详情");
    }

    //初始化控件
    private void initView() {
        //获取控件id
        toolbar = findViewById(R.id.readpoem_toolbar);
        closeButton = findViewById(R.id.readpoem_setbgclose);
        frameLayout = findViewById(R.id.readpoem_setbg);
        frameMainLayout = findViewById(R.id.readpoem_layout);
        textView = findViewById(R.id.readpoem_content);

        //获得屏幕分辨率
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);//屏幕适配分辨率

        //方法实现
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());//文本可滑动显示
        //textView.setHorizontallyScrolling(true);
        //textView.setFocusable(true);
        //底端按钮适配
        buttomNavigationView();

    }

    //底端按钮
    private void buttomNavigationView() {
        BottomNavigationView navigation = findViewById(R.id.readpoem_bottomtoolbar);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //赋值
                //界面调整
                layoutParams.width = (width*1);
                layoutParams.height = (int)(height*0.5);
                layoutParams.setMargins(30,20,30,20);
                textView.setLayoutParams(layoutParams);
                frameLayout.setVisibility(View.VISIBLE);
                switch (item.getItemId()){
                    case R.id.bt_bj:
                        replaceFragment(new PoemReadBJFragment());
                        break;
                    case R.id.bt_zs:
                        replaceFragment(new PoemReadZSFragment());
                        break;
                    case R.id.bt_yw:
                        replaceFragment(new PoemReadYWFragment());
                        break;
                    case R.id.bt_sx:
                        replaceFragment(new PoemReadSXFragment());
                        break;
                    case R.id.bt_ts:
                        replaceFragment(new PoemReadTSFragment());
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }
    //按钮监听
    private void buttomBtOnClick() {
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutParams.width = width;
                layoutParams.height = height;
                layoutParams.setMargins(30,30,30,30);
                textView.setLayoutParams(layoutParams);
                frameLayout.setVisibility(View.GONE);
            }
        });

    }

    //fragment切换
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   //开启转换事务
        transaction.replace(R.id.readpoem_setbg,fragment);
        transaction.commit();   //提交并结束事务
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
