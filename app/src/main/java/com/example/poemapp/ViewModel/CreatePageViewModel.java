package com.example.poemapp.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreatePageViewModel extends ViewModel {
    //管理的属性
    private MutableLiveData<String> editText;//用户创作的文字

    /**
     * 方法
     */
    //获取文字
    public MutableLiveData<String> getEditText() {
        if (editText == null){
            editText = new MutableLiveData<String>();
            editText.setValue("请输入文字");
        }
        return editText;
    }
    //用户添加方法
    public void addEditText(String str){
        editText.setValue(str);
    }

}
