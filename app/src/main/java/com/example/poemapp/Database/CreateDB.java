package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**用户自己创作诗歌制作图片信息
 * Created by dell on 2019/3/21.
 */

public class CreateDB extends LitePalSupport{
    private String createContent;
    private int createBGImageID;
    private int createPBImageID;
    private int createFontImageID;
    private String createTips;




    public String getCreateTips() {
        return createTips;
    }

    public void setCreateTips(String createTips) {
        this.createTips = createTips;
    }

    public String getCreateContent() {
        return createContent;
    }

    public void setCreateContent(String createContent) {
        this.createContent = createContent;
    }

    public void setCreateBGImageID(int createBGImageID) {
        this.createBGImageID = createBGImageID;
    }

    public int getCreateBGImageID() {
        return createBGImageID;
    }

    public int getCreatePBImageID() {
        return createPBImageID;
    }

    public void setCreatePBImageID(int createPBImageID) {
        this.createPBImageID = createPBImageID;
    }

    public int getCreateFontImageID() {
        return createFontImageID;
    }

    public void setCreateFontImageID(int createFontImageID) {
        this.createFontImageID = createFontImageID;
    }
}
