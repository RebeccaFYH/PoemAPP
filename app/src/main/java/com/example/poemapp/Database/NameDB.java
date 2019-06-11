package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**取名库
 * Created by dell on 2019/3/21.
 */

public class NameDB extends LitePalSupport {
    private String name;        //名字
    private String nameStyle;   //风格
    private int nameGender;     //性别

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameStyle() {
        return nameStyle;
    }

    public void setNameStyle(String nameStyle) {
        this.nameStyle = nameStyle;
    }

    public int getNameGender() {
        return nameGender;
    }

    public void setNameGender(int nameGender) {
        this.nameGender = nameGender;
    }
}
