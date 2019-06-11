package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**
 * 用户制作储存
 */

public class UserMakeDB extends LitePalSupport {
    private int diyBackground;  //diy预览图

    public int getDiyBackground() {
        return diyBackground;
    }

    public void setDiyBackground(int diyBackground) {
        this.diyBackground = diyBackground;
    }
}
