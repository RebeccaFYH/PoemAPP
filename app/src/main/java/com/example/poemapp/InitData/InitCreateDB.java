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
            createDB[i].save();
            //往下读
            lineCreateTips = bfCreateTips.readLine();
        }
        initFJImageID();
        initFontImageID();
        initBGImageID();
        initPBImageID();
        initRWImageID();
    }
    //初始化风景预览图
    private void initFJImageID() {
        createDB[0].setCreateFJImageID(R.drawable.bg_001);
        createDB[0].save();
        createDB[1].setCreateFJImageID(R.drawable.bg_002);
        createDB[1].save();
        createDB[2].setCreateFJImageID(R.drawable.bg_003);
        createDB[2].save();
        createDB[3].setCreateFJImageID(R.drawable.bg_004);
        createDB[3].save();
        createDB[4].setCreateFJImageID(R.drawable.bg_005);
        createDB[4].save();
        createDB[5].setCreateFJImageID(R.drawable.bg_006);
        createDB[5].save();
        createDB[6].setCreateFJImageID(R.drawable.bg_007);
        createDB[6].save();
        createDB[7].setCreateFJImageID(R.drawable.bg_008);
        createDB[7].save();

    }

    //初始化人物预览图
    private void initRWImageID() {
        createDB[0].setCreateRWImageID(R.drawable.bgchara_01);
        createDB[0].save();
        createDB[1].setCreateRWImageID(R.drawable.bgchara_02);
        createDB[1].save();
        createDB[2].setCreateRWImageID(R.drawable.bgchara_03);
        createDB[2].save();
        createDB[3].setCreateRWImageID(R.drawable.bgchara_04);
        createDB[3].save();
        createDB[4].setCreateRWImageID(R.drawable.bgchara_05);
        createDB[4].save();
        createDB[5].setCreateRWImageID(R.drawable.bgchara_06);
        createDB[5].save();
        createDB[6].setCreateRWImageID(R.drawable.bgchara_07);
        createDB[6].save();
        createDB[7].setCreateRWImageID(R.drawable.bgchara_08);
        createDB[7].save();
    }

    //初始化排版预览图
    private void initPBImageID() {
        createDB[0].setCreatePBImageID(R.drawable.bgyl_01);
        createDB[0].save();
        createDB[1].setCreatePBImageID(R.drawable.bgyl_02);
        createDB[1].save();
        createDB[2].setCreatePBImageID(R.drawable.bgyl_03);
        createDB[2].save();
        createDB[3].setCreatePBImageID(R.drawable.bgyl_04);
        createDB[3].save();
    }

    //初始化背景预览图
    private void initBGImageID() {
        createDB[0].setCreateBGImageID(R.drawable.bg_10);
        createDB[0].save();
        createDB[1].setCreateBGImageID(R.drawable.bg_11);
        createDB[1].save();
        createDB[2].setCreateBGImageID(R.drawable.bg_12);
        createDB[2].save();
        createDB[3].setCreateBGImageID(R.drawable.bg_13);
        createDB[3].save();
        createDB[4].setCreateBGImageID(R.drawable.bg_14);
        createDB[4].save();
        createDB[5].setCreateBGImageID(R.drawable.bg_15);
        createDB[5].save();
        createDB[6].setCreateBGImageID(R.drawable.bg_16);
        createDB[6].save();
        createDB[7].setCreateBGImageID(R.drawable.bg_17);
        createDB[7].save();
        createDB[8].setCreateBGImageID(R.drawable.bg_18);
        createDB[8].save();
        createDB[9].setCreateBGImageID(R.drawable.bg_19);
        createDB[9].save();
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
