package com.example.poemapp.Activity;

import android.content.Intent;
import androidx.annotation.NonNull;

import com.example.poemapp.InitData.InitCommuicateFunDB;
import com.example.poemapp.InitData.InitCreateDB;
import com.example.poemapp.InitData.InitNameDB;
import com.example.poemapp.InitData.InitPostDB;
import com.example.poemapp.InitData.InitUserMakeDB;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;


import com.example.poemapp.Fragment.CommunicatePageFragment;
import com.example.poemapp.Fragment.CreatePageFinishFragment;
import com.example.poemapp.Fragment.FunPageFragment;
import com.example.poemapp.Fragment.StudyPageFragment;
import com.example.poemapp.Fragment.CreatePageFragment;

import com.example.poemapp.JavaClass.BottomNavigationViewHelper;
import com.example.poemapp.R;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends BaseActivity {
    //全局声明
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    CircleImageView circleImageView;
    View headLayout;
    ImageView imageView;
    TextView titleText,finishText;
    MenuItem searchMI,indexMI,finishMI,shareMI,moomMI;
    Menu drawerMenu;
    LayoutInflater layoutInflater;
    View view;
    boolean isFirstRun;
    SharedPreferences.Editor editor;
    CreatePageFragment createPageFragment = new CreatePageFragment();

    //控制量
    private Boolean mVisiable = true;
    private int mSwitch = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeitem();
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences=this.getSharedPreferences("share",MODE_PRIVATE);
        isFirstRun=sharedPreferences.getBoolean("isFirstRun", true);
        editor=sharedPreferences.edit();


        setContentView(R.layout.activity_main);
        replaceFragment(new StudyPageFragment());

        //调用控件
        initView();
        //左滑菜单响应
        drawerLayoutListener();
    }



    /**
     * 方法实现
     */
    //控件实现
    public void initView(){
        //获取控件id
        layoutInflater = getLayoutInflater();
        finishText = (TextView) layoutInflater.inflate
                (R.layout.tab_peitu,null).findViewById(R.id.peitu_text);
        view = layoutInflater.inflate(R.layout.tab_peitu,null);
        finishText = view.findViewById(R.id.peitu_text);
        toolbar = findViewById(R.id.study_toolbar);
        drawerLayout = findViewById(R.id.study_drawerlayout);
        navigationView = findViewById(R.id.zuohua_menu);
        headLayout = navigationView.inflateHeaderView(R.layout.nav_header);
        titleText = findViewById(R.id.title_text);

        //顶端标题
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_menu);
        }

        //底端按钮事件
        bottomNavigationEvent();

        //左滑菜单顶部头像响应
        imageView = headLayout.findViewById(R.id.icon_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });



    }

    //底端按钮
    private void bottomNavigationEvent() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        //BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {   //监听器
                setmSwitch(0);
                switch (item.getItemId()){
                    case R.id.bt_study:
                        replaceFragment(new StudyPageFragment());
                        titleText.setText("学诗");
                        mVisiable = true;
                        invalidateOptionsMenu();
                        break;
                    case R.id.bt_create:
                        //判断是否第一次运行
                        if(isFirstRun){
                            editor.putBoolean("isFirstRun", false);
                            editor.commit();

                            try {
                                InitCreateDB initCreateDB = new InitCreateDB(MainActivity.this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        replaceFragment(createPageFragment);
                        titleText.setText("诗作");
                        mVisiable = false;
                        invalidateOptionsMenu();
                        break;
                    case R.id.bt_shequ:
                        //判断是否第一次运行
                        if(isFirstRun){
                            editor.putBoolean("isFirstRun", false);
                            editor.putBoolean("isComuunicatePageVisited",true);
                            editor.commit();

                            InitCommuicateFunDB initCommuicateFunDB = new InitCommuicateFunDB(MainActivity.this);

                        }
                        replaceFragment(new CommunicatePageFragment());
                        titleText.setText("诗社");
                        mVisiable = false;
                        invalidateOptionsMenu();
                        break;
                    case R.id.bt_fun:
                        if(isFirstRun){
                            editor.putBoolean("isFirstRun", false);
                            editor.commit();

                            try {
                                InitNameDB initNameDB = new InitNameDB(MainActivity.this);
                                InitUserMakeDB initUserMakeDB = new InitUserMakeDB(MainActivity.this);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        replaceFragment(new FunPageFragment());
                        titleText.setText("诗趣");
                        mVisiable = false;
                        invalidateOptionsMenu();
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
        searchMI = menu.findItem(R.id.search);
        indexMI = menu.findItem(R.id.index);
        finishMI = menu.findItem(R.id.finish);
        shareMI = menu.findItem(R.id.share);

        //动态设置可见
        finishMI.setVisible(false);
        shareMI.setVisible(false);

        if (mVisiable){
            searchMI.setVisible(true);
            indexMI.setVisible(true);
        }else {
            searchMI.setVisible(false);
            indexMI.setVisible(false);
        }

        if (mSwitch == 2){
            finishMI.setVisible(true);
        }else if (mSwitch == 3){
            shareMI.setVisible(true);
        }

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
                Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent1);
                break;
            case R.id.index:
                Intent intent2 = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent2);
                break;
            case R.id.finish:
                viewSaveToImage(createPageFragment.saveView());
                setmSwitch(3);
                replaceFragment(new CreatePageFinishFragment());
                break;
            case R.id.share:
                break;
            default:
                break;
        }
        return true;
    }

    //左滑菜单响应
    public void drawerLayoutListener(){
        //夜间开关
        drawerMenu = navigationView.getMenu();
        moomMI = drawerMenu.findItem(R.id.nav_moon);
        Switch moomSwitch = (Switch) moomMI.getActionView();


        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            moomSwitch.setChecked(true);

        }
        moomSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                      if (isChecked){
                                                          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                                          restartApp();
                                                          Log.d(String.valueOf(MainActivity.this),"夜间模式开启");
                                                      }else {
                                                          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                                                          restartApp();
                                                          Log.d(String.valueOf(MainActivity.this),"夜间模式关闭");
                                                      }
                                                  }
                                              }

        );
        //左滑菜单按钮监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_setting:
                        Intent intenta = new Intent(MainActivity.this,SettingActivity.class);
                        startActivity(intenta);
                        break;
                    case R.id.nav_friend:
                        Intent intentb = new Intent(MainActivity.this,FriendActivity.class);
                        startActivity(intentb);
                        break;
                    case R.id.nav_msg:
                        Intent intentc = new Intent(MainActivity.this,MsgActivity.class);
                        startActivity(intentc);
                        break;
                    case R.id.nav_collection:
                        Intent intentd = new Intent(MainActivity.this,MyCollectionActivity.class);
                        startActivity(intentd);
                        break;
                    case R.id.nav_langsong:
                        Intent intente = new Intent(MainActivity.this,MyIntonationActivity.class);
                        startActivity(intente);
                        break;
                    case R.id.nav_write:
                        Intent intentf = new Intent(MainActivity.this,MyWorksActivity.class);
                        startActivity(intentf);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });


    }

    //fragment切换
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   //开启转换事务
        transaction.replace(R.id.main_layout,fragment);
        transaction.commit();   //提交并结束事务
    }

    //mSwitch控制量设置，影响标题栏按钮动态显示
    public void setmSwitch(int index){
        mSwitch = index;
        invalidateOptionsMenu();
    }

    //夜间模式
    private void changeitem() {
        if(AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);

        }
        else setTheme(R.style.AppTheme);

    }
    public void restartApp(){

        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();

    }

    public void viewSaveToImage(View view) {
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        view.setDrawingCacheBackgroundColor(Color.WHITE);

        // 把一个View转换成图片
        Bitmap cachebmp = loadBitmapFromView(view);

        FileOutputStream fos;
        String imagePath = "";
        try {
            // 判断手机设备是否有SD卡
            boolean isHasSDCard = Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED);
            if (isHasSDCard) {
                // SD卡根目录
                String sdCardDir = Environment.getExternalStorageDirectory() + "/DCIM/";
                File file = new File(sdCardDir, Calendar.getInstance().getTimeInMillis()+".png");
                fos = new FileOutputStream(file);
                imagePath = file.getAbsolutePath();
            } else
                throw new Exception("创建文件失败!");

            cachebmp.compress(Bitmap.CompressFormat.PNG, 90, fos);

            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("imagePath=",imagePath);

        view.destroyDrawingCache();
    }

    private Bitmap loadBitmapFromView(View v) {
        int w = v.getWidth();
        int h = v.getHeight();

        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);

        c.drawColor(Color.WHITE);
        /** 如果不设置canvas画布为白色，则生成透明 */

        v.layout(0, 0, w, h);
        v.draw(c);

        return bmp;
    }



}
