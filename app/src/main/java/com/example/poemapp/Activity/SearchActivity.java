package com.example.poemapp.Activity;

import android.os.Bundle;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poemapp.Database.NameDB;
import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import org.litepal.FluentQuery;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/3/27.
 */

public class SearchActivity extends BaseActivity {
    //全局声明
    Toolbar searchToolbar;
    SearchView searchView;
    MenuItem menuItem;
    ActionBar actionBar;
    TextView searchAllText,searchPoemNameText,searchPoemWriterText,
                searchMiniVideoText,searchpoemPostText,searchpoemGameText,searchMakeNameText;
    TableLayout tableLayout;
    NestedScrollView searchResultView;

    //数据库对象
    List<PoemDB> poemDBList;
    List<PostDB> postDBList;
    List<NameDB> nameDBList;

    //控制量
    Boolean mSearchAll = true;
    Boolean mTableVisable = true;
    //搜索指定
    Boolean isPoemName = false;
    Boolean isPoemWriter = false;
    Boolean isMiniVideo = false;
    Boolean isPoemPost = false;
    Boolean isPoemGame = false;
    Boolean isMakeName = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //初始化控件
        initView();
    }

    /**
     * 方法实现
     */

    //初始化标题栏菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_search,menu);
        menuItem = menu.findItem(R.id.app_bar_search);

        //搜索框相关参数
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconifiedByDefault(false);  //默认展开搜索框
        searchView.setQueryHint("输入搜索内容");

        //搜索框事件
        setSearchView();

        return true;
    }
    //初始化控件
    private void initView(){
        //获取控件id
        searchResultView = findViewById(R.id.search_resultAll);
        searchToolbar = findViewById(R.id.search_toolbar);

        tableLayout = findViewById(R.id.search_table);
        searchAllText = findViewById(R.id.search_all);
        searchMakeNameText= findViewById(R.id.search_makeName);
        searchMiniVideoText = findViewById(R.id.search_miniVideo);
        searchpoemGameText = findViewById(R.id.search_poemGame);
        searchPoemNameText = findViewById(R.id.search_poemTitle);
        searchpoemPostText = findViewById(R.id.search_poemPost);
        searchPoemWriterText = findViewById(R.id.search_poemWriter);

        //功能实现
        setSupportActionBar(searchToolbar); //标题栏
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.nav_back);
        }
        //按钮响应
        setTextListener();


    }

    //搜索框事件
    private void setSearchView() {
        //回车为搜索
        searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

        //文本监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //诗词表查询(包含诗人)
                poemDBList = LitePal.where("poemContent like ?","%"+query+"%")
                        .order("poemID").find(PoemDB.class);
                //诗贴查询
                postDBList = LitePal.where("postContent like ?","%"+query+"%")
                        .find(PostDB.class);
                //名字查询
                nameDBList = LitePal.where("name like ?","%"+query+"%")
                        .find(NameDB.class);

                setResultView();
                searchResultView.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    searchResultView.setVisibility(View.GONE);
                }

                return false;
            }
        });
    }
    //设置搜索结果视图
    private void setResultView(){

    }

    //标题栏按钮响应
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

    //文字相应
    public void setTextListener(){
        //搜索全部
        searchAllText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });
        //指定搜索
        //-------诗词
        searchPoemNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
                isPoemName = true;
                Toast.makeText(SearchActivity.this,"搜索诗词……",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //-------诗人
        searchPoemWriterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
                isPoemWriter = true;
                Toast.makeText(SearchActivity.this,"搜索诗人……",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //-------微课堂
        searchMiniVideoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
                isMiniVideo = true;
                Toast.makeText(SearchActivity.this,"搜索微课堂……",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //-------诗贴
        searchpoemPostText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
                isPoemPost = true;
                Toast.makeText(SearchActivity.this,"搜索诗贴……",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //-------诗游戏
        searchpoemGameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
                isPoemGame = true;
                Toast.makeText(SearchActivity.this,"搜索诗游戏……",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //-------取名
        searchMakeNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
                isMakeName = true;
                Toast.makeText(SearchActivity.this,"搜索取名……",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    //开关转换
    public void toggle(){
        if (mSearchAll){
            mTableVisable = false;
            mSearchAll = false;
            searchAllText.setText("返回");
        }else {
            mTableVisable = true;
            mSearchAll = true;
            searchAllText.setText("搜索指定内容");
        }

        if (mTableVisable){
            tableLayout.setVisibility(View.VISIBLE);
            Boolean isPoemName = false;
            Boolean isPoemWriter = false;
            Boolean isMiniVideo = false;
            Boolean isPoemPost = false;
            Boolean isPoemGame = false;
            Boolean isMakeName = false;
        }else {
            tableLayout.setVisibility(View.GONE);
        }
    }

    //搜索【全部】结果适配器
    private void setSearchResultAll(List<PoemDB> poemDBS,List<PostDB> postDBS,List<NameDB> nameDBS){

    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
