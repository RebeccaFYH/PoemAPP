package com.example.poemapp.InitData;

import android.content.Context;
import android.renderscript.Sampler;
import android.util.Log;

import com.example.poemapp.Database.CommunicateFunDB;

import org.litepal.LitePal;

import java.util.List;

public class InitCommuicateFunDB {
    //声明
    CommunicateFunDB communicateFunDB[] = new CommunicateFunDB[20];

    //构造方法
    public InitCommuicateFunDB(Context context){
        init(context);
    }

    //初始化
    private void init(Context context) {
        for (int i=0;i<10;i++){
            communicateFunDB[i] = new CommunicateFunDB();
            communicateFunDB[i].setFunLabel("诗词接龙");
            communicateFunDB[i].setFunTitle("顺接——“把酒问青天”");
            communicateFunDB[i].save();

//            communicateFunDB[(i+1)] = new CommunicateFunDB();
//            communicateFunDB[i+1].setFunLabel("诗词接龙");
//            communicateFunDB[i+1].setFunTitle("逆接——“明月几时有”");
//            communicateFunDB[i+1].save();
//
//            communicateFunDB[i+2] = new CommunicateFunDB();
//            communicateFunDB[i+2].setFunLabel("诗词造句");
//            communicateFunDB[i+2].setFunTitle("“哟哟鹿鸣”");
//            communicateFunDB[i+2].save();

            Log.d("InitCommunicateFunDB",communicateFunDB[i].getFunLabel());
            Log.d("InitCommunicateFunDB",communicateFunDB[i].getFunTitle());
        }
        List<CommunicateFunDB> communicateFunDBS = LitePal.findAll(CommunicateFunDB.class);
        int d = communicateFunDBS.size();
    }
}
