package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**诗词信息
 * Created by dell on 2019/3/21.
 */

public class PoemDB extends LitePalSupport{
    private int poemImageID;
    private int poemID;
    private String poemName;            //诗名
    private String poemZhushi;          //注释
    private String poemTranslation;     //译文
    private String poemAppreciation;    //赏析
    private String poemSpot;
    private String poemPTRadioPath; //普通话音频路径
    private String poemFYRadioPath; //方言音频路径
    private String poemKeyWord;
    private String poemFromBook;
    private String poemStyle;       //主题
    private String poemContent;         //诗文内容
    private String poemWriterName;  //诗词作者（主码）
    private String poemCreateBackgrond; //诗词创作背景（联系集）
    private String poemCreateTime;  //诗词创作时期（联系集）
    private String poemTopic;       //主题
    private String poemPai;         //派系
    private String isCollect;      //是否收藏

    ///////////////////get/////////////////
    public int getPoemID() {
        return poemID;
    }

    public int getPoemImageID() {
        return poemImageID;
    }

    public String getPoemName() {
        return poemName;
    }

    public String getPoemZhushi() {
        return poemZhushi;
    }

    public String getPoemAppreciation() {
        return poemAppreciation;
    }

    public String getPoemFYRadioPath() {
        return poemFYRadioPath;
    }

    public String getPoemFromBook() {
        return poemFromBook;
    }

    public String getPoemPTRadioPath() {
        return poemPTRadioPath;
    }

    public String getPoemKeyWord() {
        return poemKeyWord;
    }

    public String getPoemSpot() {
        return poemSpot;
    }

    public String getPoemTranslation() {
        return poemTranslation;
    }

    public String getPoemContent() {
        return poemContent;
    }

    public String getPoemCreateBackgrond() {
        return poemCreateBackgrond;
    }

    public String getPoemCreateTime() {
        return poemCreateTime;
    }

    public String getPoemStyle() {
        return poemStyle;
    }

    public String getPoemWriterName() {
        return poemWriterName;
    }

    ////////////////////set//////////////////


    public void setPoemID(int poemID) {
        this.poemID = poemID;
    }

    public void setPoemAppreciation(String poemAppreciation) {
        this.poemAppreciation = poemAppreciation;
    }

    public void setPoemZhushi(String poemZhushi) {
        this.poemZhushi = poemZhushi;
    }

    public void setPoemFYRadioPath(String poemFYRadioPath) {
        this.poemFYRadioPath = poemFYRadioPath;
    }

    public void setPoemImageID(int poemImageID) {
        this.poemImageID = poemImageID;
    }

    public void setPoemFromBook(String poemFromBook) {
        this.poemFromBook = poemFromBook;
    }

    public void setPoemName(String poemName) {
        this.poemName = poemName;
    }

    public void setPoemKeyWord(String poemKeyWord) {
        this.poemKeyWord = poemKeyWord;
    }

    public void setPoemPTRadioPath(String poemPTRadioPath) {
        this.poemPTRadioPath = poemPTRadioPath;
    }

    public void setPoemSpot(String poemSpot) {
        this.poemSpot = poemSpot;
    }

    public void setPoemStyle(String poemStyle) {
        this.poemStyle = poemStyle;
    }

    public void setPoemTranslation(String poemTranslation) {
        this.poemTranslation = poemTranslation;
    }

    public void setPoemContent(String poemContent) {
        this.poemContent = poemContent;
    }

    public void setPoemCreateBackgrond(String poemCreateBackgrond) {
        this.poemCreateBackgrond = poemCreateBackgrond;
    }

    public void setPoemCreateTime(String poemCreateTime) {
        this.poemCreateTime = poemCreateTime;
    }

    public void setPoemWriterName(String poemWriterName) {
        this.poemWriterName = poemWriterName;
    }


    public String getPoemTopic() {
        return poemTopic;
    }

    public void setPoemTopic(String poemTopic) {
        this.poemTopic = poemTopic;
    }

    public String getPoemPai() {
        return poemPai;
    }

    public void setPoemPai(String poemPai) {
        this.poemPai = poemPai;
    }

    public String getCollect() {
        return isCollect;
    }

    public void setCollect(String collect) {
        isCollect = collect;
    }
}
