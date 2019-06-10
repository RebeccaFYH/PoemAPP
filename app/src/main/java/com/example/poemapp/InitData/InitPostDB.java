package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.poemapp.Database.PostDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InitPostDB {
    PostDB postDB[] = new PostDB[40];

    public InitPostDB(Context context) throws IOException{
        init(context);
    }

    private void init(Context context) throws IOException {
        //创建输入流对象
        AssetManager am = context.getAssets();

        InputStream istrPostUserName = am.open("communication_chara.txt");
        InputStream istrPostContent = am.open("communication_content.txt");


        //缓冲区对象，读取
        BufferedReader bfPostUserName = new BufferedReader(new InputStreamReader(istrPostUserName));
        BufferedReader bfPostContent = new BufferedReader(new InputStreamReader(istrPostContent));

        //获取的信息
        String linePostUserName;
        String linePostContent;

        linePostUserName = bfPostUserName.readLine();
        linePostContent = bfPostContent.readLine();

        for (int i=0;linePostUserName !=null;i++){
            postDB[i] = new PostDB();
            postDB[i].setUserName(linePostUserName);
            postDB[i].setPostContent(linePostContent);
            postDB[i].save();

            //往下读
            linePostUserName = bfPostUserName.readLine();
            linePostContent = bfPostContent.readLine();
        }

    }
}
