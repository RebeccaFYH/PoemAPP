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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poemapp.Database.NameDB;
import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.Database.WriterDB;
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
    LinearLayout searchResultView,searchClassifyView;
    ListView listView;

    //结果文本框
    TextView    allPoem,allPoemWriter,allPoemPost,allName,
                allPoem1,allPoem2,allPoem3,
                allPoemWriter1,allPoemWriter2,allPoemWriter3,
                allPoemPost1,allPoemPost2,allPoemPost3,
                allName1,allName2,allName3;
    TextView searchClassifyTitle;       //分类结果

    //数据库对象
    List<PoemDB> poemDBList;
    List<WriterDB> writerDBList;
    List<PostDB> postDBList;
    List<NameDB> nameDBList;
    String[] data;

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
        searchClassifyView = findViewById(R.id.search_classify);
        searchToolbar = findViewById(R.id.search_toolbar);
        listView = findViewById(R.id.search_classify_content);

        tableLayout = findViewById(R.id.search_table);
        searchAllText = findViewById(R.id.search_all);
        searchMakeNameText= findViewById(R.id.search_makeName);
        searchMiniVideoText = findViewById(R.id.search_miniVideo);
        searchpoemGameText = findViewById(R.id.search_poemGame);
        searchPoemNameText = findViewById(R.id.search_poemTitle);
        searchpoemPostText = findViewById(R.id.search_poemPost);
        searchPoemWriterText = findViewById(R.id.search_poemWriter);

        //文本框控件id获得
        getAllTextView();

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
    //文本框控件获得（结果）
    private void getAllTextView() {
        //全部结果
        allPoem = findViewById(R.id.search_poem);
        allPoem1 = findViewById(R.id.search_poem01);
        allPoem2 = findViewById(R.id.search_poem02);
        allPoem3 = findViewById(R.id.search_poem03);

        allPoemWriter = findViewById(R.id.search_poemwriter);
        allPoemWriter1 = findViewById(R.id.search_poemWriter01);
        allPoemWriter2 = findViewById(R.id.search_poemWriter02);
        allPoemWriter3 = findViewById(R.id.search_poemWriter03);

        allPoemPost = findViewById(R.id.search_poempost);
        allPoemPost1 = findViewById(R.id.search_poemPost01);
        allPoemPost2 = findViewById(R.id.search_poemPost02);
        allPoemPost3 = findViewById(R.id.search_poemPost03);

        allName = findViewById(R.id.search_makename);
        allName1 = findViewById(R.id.search_makeName01);
        allName2 = findViewById(R.id.search_makeName02);
        allName3 = findViewById(R.id.search_makeName03);

        //部分结果标题
        searchClassifyTitle = findViewById(R.id.search_classify_title);

    }

    //搜索框事件
    private void setSearchView() {
        //回车为搜索
        searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

        //文本监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mSearchAll){
                    //诗词表查询
                    poemDBList = LitePal.where("poemContent like ?","%"+query+"%").limit(3)
                            .order("poemID").find(PoemDB.class);
                    //诗人查询
                    writerDBList = LitePal.where("writerName like ?","%"+query+"%").limit(3)
                            .find(WriterDB.class);
                    //诗贴查询
                    postDBList = LitePal.where("postContent like ?","%"+query+"%").limit(3)
                            .find(PostDB.class);
                    //名字查询
                    nameDBList = LitePal.where("name like ?","%"+query+"%").limit(3)
                            .find(NameDB.class);

                    setSearchResultAll(poemDBList,writerDBList,postDBList,nameDBList);

                    searchResultView.setVisibility(View.VISIBLE);
                }else {
                    if (isPoemName){
                        poemDBList = LitePal.where("poemContent like ?","%"+query+"%")
                                .order("poemID").find(PoemDB.class);
                        setPoemNameResult(poemDBList);
                    }else if (isPoemWriter){
                        writerDBList = LitePal.where("writerName like ?","%"+query+"%")
                                .find(WriterDB.class);
                        setPoemWriterResult(writerDBList);
                    }else if (isPoemPost){
                        postDBList = LitePal.where("postContent like ?","%"+query+"%")
                                .find(PostDB.class);
                        setPoemPostResult(postDBList);
                    }else if (isMakeName){
                        nameDBList = LitePal.where("name like ?","%"+query+"%")
                                .find(NameDB.class);
                        setPoemMakeName(nameDBList);
                    }

                    searchClassifyView.setVisibility(View.VISIBLE);
                }



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    searchResultView.setVisibility(View.GONE);
                    searchClassifyView.setVisibility(View.GONE);
                }

                return false;
            }
        });
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
                searchClassifyTitle.setText("诗词");
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
    private void setSearchResultAll(List<PoemDB> poemDBS,List<WriterDB> writerDBS,List<PostDB> postDBS,List<NameDB> nameDBS){
        allPoem.setText("诗词");
        allPoemWriter.setText("诗人");
        allPoemPost.setText("诗贴");
        allName.setText("取名");

        //验证是否为空(诗词
        if (poemDBS != null){
            if (poemDBS.size() == 1){
                PoemDB poemDB = new PoemDB();
                allPoem1.setText(poemDB.getPoemKeyWord()+"《"+poemDB.getPoemName()+"》");
                allPoem2.setText("空");
                allPoem3.setText("空");
            }else {
                for (PoemDB poemDB:poemDBS){
                    allPoem1.setText(poemDB.getPoemKeyWord()+"《"+poemDB.getPoemName()+"》");
                    allPoem2.setText(poemDB.getPoemKeyWord()+"《"+poemDB.getPoemName()+"》");
                    allPoem3.setText(poemDB.getPoemKeyWord()+"《"+poemDB.getPoemName()+"》");
                }
            }
        }else {
            allPoem1.setText("空");
            allPoem2.setText("空");
            allPoem3.setText("空");
        }

        //验证是否为空（诗人
        if (writerDBS != null){
            if (writerDBS.size()==1){
                WriterDB writerDB = new WriterDB();
                allPoemWriter1.setText(writerDB.getWriterName());
                allPoemWriter2.setText("空");
                allPoemWriter3.setText("空");
            }else {
                for (WriterDB writerDB:writerDBS){
                    allPoemWriter1.setText(writerDB.getWriterName());
                    allPoemWriter2.setText(writerDB.getWriterName());
                    allPoemWriter3.setText(writerDB.getWriterName());
                }
            }
        }else {
            allPoemWriter1.setText("空");
            allPoemWriter2.setText("空");
            allPoemWriter3.setText("空");
        }

        //验证是否为空（诗贴
        if (postDBS != null){
            if (postDBS.size() == 1){
                PostDB postDB = new PostDB();
                allPoemPost1.setText(postDB.getPostContent());
                allPoemPost2.setText("空");
                allPoemPost3.setText("空");
            }else {
                for (PostDB postDB:postDBS){
                    allPoemPost1.setText(postDB.getPostContent());
                    allPoemPost2.setText(postDB.getPostContent());
                    allPoemPost3.setText(postDB.getPostContent());
                }
            }
        }else {
            allPoemPost1.setText("空");
            allPoemPost2.setText("空");
            allPoemPost3.setText("空");
        }
        //验证是否为空（取名
        if (nameDBS != null){
            if (nameDBS.size() == 1){
                NameDB nameDB = new NameDB();
                allName1.setText(nameDB.getName());
                allName2.setText("空");
                allName3.setText("空");
            }else {
                for (NameDB nameDB:nameDBS){
                    allName1.setText(nameDB.getName());
                    allName2.setText(nameDB.getName());
                    allName3.setText(nameDB.getName());
                }
            }
        }else {
            allName1.setText("空");
            allName2.setText("空");
            allName3.setText("空");
        }

    }
    //【诗词】
    private void setPoemNameResult(List<PoemDB> poemDBS){
        searchClassifyTitle.setText("诗词");

        if (poemDBS != null){
            initDataByPoemName(poemDBS);
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }else {
            data  = new String[]{"空"};
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }
    }
    //【诗人】
    private void setPoemWriterResult(List<WriterDB> writerDBS){
        searchClassifyTitle.setText("诗人");

        if (writerDBS != null){
            initDataByPoemWriter(writerDBS);
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }else {
            data  = new String[]{"空"};
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }
    }

    //【诗贴】
    private void setPoemPostResult(List<PostDB> postDBS){

        searchClassifyTitle.setText("诗帖");

        if (postDBS != null){
            initDataByPost(postDBS);
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }else {
            data  = new String[]{"空"};
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }
    }


    //【取名】
    private void setPoemMakeName(List<NameDB> nameDBS){

        searchClassifyTitle.setText("取名");
        if (nameDBS != null){
            initDataByName(nameDBS);
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }else {
            data  = new String[]{"空"};
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(SearchActivity.this,
                            android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }
    }

    //字符串数组
    private void initDataByPoemName(List<PoemDB> poemDBS){
        PoemDB poemDB = new PoemDB();
        for (int i=0;i<poemDBS.size();i++){
            poemDB = poemDBS.get(i);
            data[i] = poemDB.getPoemKeyWord();
        }
    }
    private void initDataByPoemWriter(List<WriterDB> writerDBS) {
        WriterDB writerDB = new WriterDB();
        for (int i=0;i<writerDBS.size();i++){
            writerDB = writerDBS.get(i);
            data[i] = writerDB.getWriterName();
        }
    }
    private void initDataByPost(List<PostDB> postDBS) {
        PostDB postDB = new PostDB();
        for (int i=0;i<postDBS.size();i++){
            postDB = postDBS.get(i);
            data[i] = postDB.getPostContent();
        }
    }
    private void initDataByName(List<NameDB> nameDBS) {
        NameDB nameDB = new NameDB();
        for (int i=0;i<nameDBS.size();i++){
            nameDB = nameDBS.get(i);
            data[i] = nameDB.getName();
        }
    }





    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
