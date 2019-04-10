package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dell on 2019/4/9.
 */

public class InitPoemDB {
    PoemDB poemDB[] = new PoemDB[10];

    public InitPoemDB(Context context) throws IOException {
        try {
            init(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(Context context) throws IOException {
        //创建输入流对象
        AssetManager am = context.getAssets();

        InputStream istrPoemName = am.open("poemName.txt");
        InputStream istrPoemContent = am.open("poemContent.txt");
        InputStream istrPoemKeyword = am.open("poemKeyword.txt");
        InputStream istrPoemTranslation = am.open("poemTranslation.txt");
        InputStream istrPoemZhushi = am.open("poemZhushi.txt");

        //缓冲区对象，读取
        BufferedReader bfPoemName = new BufferedReader(new InputStreamReader(istrPoemName));
        BufferedReader bfPoemContent = new BufferedReader(new InputStreamReader(istrPoemContent));
        BufferedReader bfPoemKeyword = new BufferedReader(new InputStreamReader(istrPoemKeyword));
        BufferedReader bfPoemTranslation = new BufferedReader(new InputStreamReader(istrPoemTranslation));
        BufferedReader bfPoemZhushi = new BufferedReader(new InputStreamReader(istrPoemZhushi));

        //获取的信息
        String linePoemName;
        String linePoemContent;
        String linePoemKeyWord;
        String linePoemTranslation;
        String linePoemZhushi;

        linePoemName = bfPoemName.readLine();
        linePoemContent = bfPoemContent.readLine();
        linePoemKeyWord = bfPoemKeyword.readLine();
        linePoemTranslation = bfPoemTranslation.readLine();
        linePoemZhushi = bfPoemZhushi.readLine();

        for (int i=1;linePoemName !=null;i++){
            poemDB[i] = new PoemDB();
            poemDB[i].setPoemName(linePoemName);
            poemDB[i].setPoemCotent(linePoemContent);
            poemDB[i].setPoemKeyWord(linePoemKeyWord);
            poemDB[i].setPoemTranslation(linePoemTranslation);
            poemDB[i].setPoemZhushi(linePoemZhushi);
            poemDB[i].setPoemID(R.drawable.writer_sushi);
            poemDB[i].save();

            //往下读
            linePoemName = bfPoemName.readLine();
            linePoemContent = bfPoemContent.readLine();
            linePoemKeyWord = bfPoemKeyword.readLine();
            linePoemTranslation = bfPoemTranslation.readLine();
            linePoemZhushi = bfPoemZhushi.readLine();
        }






    }
}
