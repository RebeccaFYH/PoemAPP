package com.example.poemapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.poemapp.Activity.MainActivity;
import com.example.poemapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/3/19.
 */

public class FunPageFragment extends Fragment {
    //全局声明
    Context context;
    Spinner spinner1,spinner2;
    ArrayAdapter<String> arrayAdapter1,arrayAdapter2;
    List<String> genderList,styleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_fun,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

    }

    /**
     * 方法实现
     */
    private void initView() {
        //控件id
        spinner1 = getActivity().findViewById(R.id.fun_gender_spinner);
        spinner2 = getActivity().findViewById(R.id.fun_style_spinner);

        //获取活动
        MainActivity activity = (MainActivity) getActivity();
        context = activity;

        //下拉菜单适配器
        initSpinner();



    }
    //下拉菜单适配器
    private void initSpinner() {
        //列表添加
        genderList = new ArrayList<String>();
        styleList = new ArrayList<String>();
        genderList.add("男");        //性别
        genderList.add("女");
        styleList.add("优雅");        //风格
        styleList.add("大方");
        styleList.add("活泼");
        styleList.add("自强");
        //适配器
        arrayAdapter1 = new ArrayAdapter<String>(
                context,R.layout.support_simple_spinner_dropdown_item,genderList);
        spinner1.setAdapter(arrayAdapter1);
        arrayAdapter2 = new ArrayAdapter<String>(
                context,R.layout.support_simple_spinner_dropdown_item,styleList);
        spinner2.setAdapter(arrayAdapter2);

    }
}
