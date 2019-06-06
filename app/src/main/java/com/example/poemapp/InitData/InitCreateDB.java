package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.poemapp.Database.CreateDB;
import com.example.poemapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dell on 2019/4/28.
 */

public class InitCreateDB {
    CreateDB createDB[] = new CreateDB[100];

    public InitCreateDB(Context context)throws IOException {
        try {
            init(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(Context context) throws IOException {
        //创建输入流对象
        AssetManager am = context.getAssets();

        InputStream istrCreateTips = am.open("creationTips.txt");

        //缓冲区对象，读取
        BufferedReader bfCreateTips = new BufferedReader(new InputStreamReader(istrCreateTips));

        //获取的信息
        String lineCreateTips;

        lineCreateTips = bfCreateTips.readLine();

        for (int i=0;lineCreateTips !=null;i++){
            createDB[i] = new CreateDB();
            createDB[i].setCreateTips(lineCreateTips);
            createDB[i].setCreatePBImageID(R.drawable.bg_biou);     //排版
            createDB[i].setCreateBGImageID(R.drawable.bg_fengji);   //背景（推荐）
            createDB[i].setCreateFJImageID(R.drawable.bg_modao);    //风景
            createDB[i].setCreateRWImageID(R.drawable.bg_qiwu);     //人物
            createDB[i].save();
            //往下读
            lineCreateTips = bfCreateTips.readLine();
        }
        initFontImageID();
    }
    //初始化字体预览图
    private void initFontImageID() {
        createDB[0].setCreateFontImageID(R.mipmap.font_zh);
        createDB[0].save();
        createDB[1].setCreateFontImageID(R.mipmap.font_sj);
        createDB[1].save();
        createDB[2].setCreateFontImageID(R.mipmap.font_ks);
        createDB[2].save();
        createDB[3].setCreateFontImageID(R.mipmap.font_ht);
        createDB[3].save();
    }

}
