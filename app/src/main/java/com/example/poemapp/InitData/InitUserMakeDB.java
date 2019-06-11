package com.example.poemapp.InitData;

import android.content.Context;

import com.example.poemapp.Database.UserMakeDB;
import com.example.poemapp.R;

public class InitUserMakeDB {
    UserMakeDB userMakeDB[] = new UserMakeDB[20];

    public InitUserMakeDB(Context context){
        init(context);
    }

    //初始化
    private void init(Context context) {
        for (int i=0;i<20;i++){
            userMakeDB[i] = new UserMakeDB();
        }

        userMakeDB[0].setDiyBackground(R.drawable.bg_001);
        userMakeDB[0].save();
        userMakeDB[1].setDiyBackground(R.drawable.bg_002);
        userMakeDB[1].save();
        userMakeDB[2].setDiyBackground(R.drawable.bg_003);
        userMakeDB[2].save();
        userMakeDB[3].setDiyBackground(R.drawable.bg_004);
        userMakeDB[3].save();
        userMakeDB[4].setDiyBackground(R.drawable.bg_005);
        userMakeDB[4].save();
        userMakeDB[5].setDiyBackground(R.drawable.bg_006);
        userMakeDB[5].save();
        userMakeDB[6].setDiyBackground(R.drawable.bg_007);
        userMakeDB[6].save();
        userMakeDB[7].setDiyBackground(R.drawable.bg_008);
        userMakeDB[7].save();
        userMakeDB[8].setDiyBackground(R.drawable.bg_009);
        userMakeDB[8].save();
        userMakeDB[9].setDiyBackground(R.drawable.bg_010);
        userMakeDB[9].save();
        userMakeDB[10].setDiyBackground(R.drawable.bg_011);
        userMakeDB[10].save();
        userMakeDB[11].setDiyBackground(R.drawable.bg_012);
        userMakeDB[11].save();
        userMakeDB[12].setDiyBackground(R.drawable.bg_013);
        userMakeDB[12].save();
        userMakeDB[13].setDiyBackground(R.drawable.bg_014);
        userMakeDB[13].save();
        userMakeDB[14].setDiyBackground(R.drawable.bg_015);
        userMakeDB[14].save();
        userMakeDB[15].setDiyBackground(R.drawable.bg_016);
        userMakeDB[15].save();
        userMakeDB[16].setDiyBackground(R.drawable.bg_017);
        userMakeDB[16].save();
        userMakeDB[17].setDiyBackground(R.drawable.bg_018);
        userMakeDB[17].save();
        userMakeDB[18].setDiyBackground(R.drawable.bg_019);
        userMakeDB[18].save();
        userMakeDB[19].setDiyBackground(R.drawable.bg_020);
        userMakeDB[19].save();


    }
}
