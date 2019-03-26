package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

/**作者信息
 * Created by dell on 2019/3/21.
 */

public class WriterDB extends LitePalSupport{

    private String writerName;
    private String writerYear;
    private String writerIntroduce;
    private String writerStory;
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

    public void setWriterStory(String writerStory) {
        this.writerStory = writerStory;
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

    public String getWriterStory() {
        return writerStory;
    }

    public int getWriterIconImageID() {
        return writerIconImageID;
    }
}
