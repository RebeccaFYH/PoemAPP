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

        BufferedReader bfPoemName = new BufferedReader(new InputStreamReader(istrPoemName));
        BufferedReader bfPoemContent = new BufferedReader(new InputStreamReader(istrPoemContent));


        String linePoemName;
        String linePoemContent;

        linePoemName = bfPoemName.readLine();
        linePoemContent = bfPoemContent.readLine();

        for (int i=1;linePoemName !=null;i++){
            poemDB[i] = new PoemDB();
            poemDB[i].setPoemName(linePoemName);
            poemDB[i].setPoemCotent(linePoemContent);
            poemDB[i].setPoemID(R.drawable.writer_sushi);
            poemDB[i].save();

            linePoemName = bfPoemName.readLine();
            linePoemContent = bfPoemContent.readLine();
        }






    }
}
