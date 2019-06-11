package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.poemapp.Database.NameDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class InitNameDB {
    NameDB nameDB[] = new NameDB[20];

    //变量声明
    Random random = new Random();
    private static final int M = 1;
    private static final int N = 3;

    public InitNameDB(Context context) throws IOException {
        init(context);
    }

    //初始化
    private void init(Context context) throws IOException {
        //创建输入流对象
        AssetManager am = context.getAssets();

        InputStream istrName = am.open("name.txt");

        //缓冲区对象，读取
        BufferedReader bfName = new BufferedReader(new InputStreamReader(istrName));

        //获取的信息
        String lineName;

        lineName = bfName.readLine();

        for (int i=0;lineName !=null;i++){
            nameDB[i] = new NameDB();
            nameDB[i].setName(lineName);

            final int randNum1 = random.nextInt(M);
            final int randNum2 = random.nextInt(N);

            switch (randNum1){
                case 0:
                    nameDB[i].setNameGender(0); //女性
                    break;
                case 1:
                    nameDB[i].setNameGender(1); //男性
                    break;
                    default:
                        break;
            }
            switch (randNum2){
                case 0:
                    nameDB[i].setNameStyle("优雅");
                    break;
                case 1:
                    nameDB[i].setNameStyle("大方");
                    break;
                case 2:
                    nameDB[i].setNameStyle("活泼");
                    break;
                case 3:
                    nameDB[i].setNameStyle("自强");
                    default:
                        break;
            }

            nameDB[i].save();

            //往下读
            lineName = bfName.readLine();
        }
    }
}
