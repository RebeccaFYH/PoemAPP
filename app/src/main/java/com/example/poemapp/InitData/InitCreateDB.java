package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.poemapp.Database.CreateDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dell on 2019/4/28.
 */

public class InitCreateDB {
    CreateDB createDB[] = new CreateDB[50];

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

        for (int i=1;lineCreateTips !=null;i++){
            createDB[i] = new CreateDB();
            createDB[i].setCreateTips(lineCreateTips);
            createDB[i].save();

            //往下读
            lineCreateTips = bfCreateTips.readLine();
        }

    }

}
