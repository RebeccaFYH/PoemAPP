package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.poemapp.Database.WriterDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dell on 2019/4/10.
 */

public class InitWriterDB {
    WriterDB writerDB[] = new WriterDB[30];

    public InitWriterDB(Context context) throws IOException {
        try {
            init(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(Context context) throws IOException {
        //创建输入流对象
        AssetManager am = context.getAssets();

        InputStream istrWriterName = am.open("writerName.txt");
        InputStream istrWriterIntroduce = am.open("writerIntroduce.txt");
        InputStream istrWriterYear = am.open("writerYear.txt");
        InputStream istrWriterLife= am.open("writerLife.txt");

        //缓冲区对象，读取
        BufferedReader bfWriterName = new BufferedReader(new InputStreamReader(istrWriterName));
        BufferedReader bfWriterIntroduce = new BufferedReader(new InputStreamReader(istrWriterIntroduce));
        BufferedReader bfWriterYear = new BufferedReader(new InputStreamReader(istrWriterYear));
        BufferedReader bfWriterLife = new BufferedReader(new InputStreamReader(istrWriterLife));

        //获取的信息
        String lineWriterName;
        String lineWriterIntroduce;
        String lineWriterYear;
        String lineWriterLife;

        lineWriterName = bfWriterName.readLine();
        lineWriterIntroduce = bfWriterIntroduce.readLine();
        lineWriterYear = bfWriterYear.readLine();
        lineWriterLife = bfWriterLife.readLine();

        for (int i = 0; lineWriterName != null; i++) {
            writerDB[i] = new WriterDB();
            writerDB[i].setWriterID(i);
            writerDB[i].setWriterName(lineWriterName);
            writerDB[i].setWriterIntroduce(lineWriterIntroduce);
            writerDB[i].setWriterYear(lineWriterYear);
            writerDB[i].setWriterLife(lineWriterLife);
            writerDB[i].save();

            //往下读
            lineWriterName = bfWriterName.readLine();
            lineWriterIntroduce = bfWriterIntroduce.readLine();
            lineWriterYear = bfWriterYear.readLine();
            lineWriterLife = bfWriterLife.readLine();

        }
    }
}
