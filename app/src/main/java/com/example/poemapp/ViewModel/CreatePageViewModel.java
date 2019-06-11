package com.example.poemapp.ViewModel;

import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreatePageViewModel extends ViewModel {
    //管理的属性
    private MutableLiveData<String> editText;//用户创作的文字
    private MutableLiveData<Typeface> editTf;//文本字体
    private MutableLiveData<String> topicText;//主题
    private MutableLiveData<String> contentText;//内容

    private String str,str1,str2;

    public CreatePageViewModel(){
        topicText = new MutableLiveData<String>();
        topicText.setValue("在此输入主题");
        contentText = new MutableLiveData<String>();
        contentText.setValue("在此输入内容");
        editText = new MutableLiveData<String>();
        editText.setValue("请输入文字");
        editTf = new MutableLiveData<Typeface>();
        editTf.setValue(Typeface.DEFAULT);
    }

    /**
     * 方法
     */

    //获取文字
    public MutableLiveData<String> getEditText() {
        return editText;
    }
    //用户添加方法
    public void addEditText(String str){
        editText.setValue(str);
    }
    //主题
    public void addTopicText(String string){
        topicText.setValue(string);

    }
    //内容
    public void addContentText(String string){
        contentText.setValue(string);
    }
    //文本字体
    public MutableLiveData<Typeface> getEditTf() {
        return editTf;
    }
    //用户更改
    public void addTypeface(Typeface typeface){
        editTf.setValue(typeface);
    }
}
