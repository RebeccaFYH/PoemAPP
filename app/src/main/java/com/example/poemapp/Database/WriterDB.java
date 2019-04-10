package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**作者信息
 * Created by dell on 2019/3/21.
 */

public class WriterDB extends LitePalSupport{

    private String writerName;
    private String writerYear;
    private String writerIntroduce;
    private String writerLife;
    private int writerIconImageID;
//设置
    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setWriterYear(String writerYear) {
        this.writerYear = writerYear;
    }

    public void setWriterIntroduce(String writerIntroduce) {
        this.writerIntroduce = writerIntroduce;
    }

    public void setWriterLife(String writerLife) {
        this.writerLife = writerLife;
    }

    public void setWriterIconImageID(int writerIconImageID) {
        this.writerIconImageID = writerIconImageID;
    }

    //获取
    public String getWriterName() {
        return writerName;
    }

    public String getWriterYear() {
        return writerYear;
    }

    public String getWriterIntroduce() {
        return writerIntroduce;
    }

    public String getWriterLife() {
        return writerLife;
    }

    public int getWriterIconImageID() {
        return writerIconImageID;
    }
}
