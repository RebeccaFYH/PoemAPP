package com.example.poemapp.JavaClass;

import android.app.Activity;
import android.content.Context;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.poemapp.Database.CreateDB;
import com.example.poemapp.R;
import com.example.poemapp.databinding.TabYangshiBinding;

import java.util.List;

/**
 * Created by dell on 2019/4/29.
 */

public class CreateCardFontAdapter extends RecyclerView.Adapter<CreateCardFontAdapter.ViewHolder>{
    //声明
    private List<CreateDB> createDBS;
    Context mcontext;
    TabYangshiBinding binding;
    AssetManager mgr;   //初始数据管理对象
    Typeface tf;    //字体
    LayoutInflater layoutInflater;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView font_image;

        public ViewHolder(View itemView) {
            super(itemView);
            font_image = (ImageView)itemView.findViewById(R.id.create_font);
        }
    }

    //构造方法
    public CreateCardFontAdapter(List<CreateDB> createDBList,Context context){
        createDBS = createDBList;
        mcontext = context;
        mgr = context.getAssets();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_font,parent,false);
        ViewHolder holder = new ViewHolder(view);

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.tab_yangshi,parent,false);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CreateDB createDB = createDBS.get(position);
        holder.font_image.setImageResource(createDB.getCreateFontImageID());

        //点击事件
        holder.font_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        tf = Typeface.createFromAsset(mgr,"zhenhun.ttf");
                        binding.yangshiText.setTypeface(tf);
                        break;
                    case 1:
                        tf = Typeface.createFromAsset(mgr,"shoujin.ttf");
                        binding.yangshiText.setTypeface(tf);
                        break;
                    case 2:
                        tf = Typeface.createFromAsset(mgr,"kaishu.ttf");
                        binding.yangshiText.setTypeface(tf);
                        break;
                    case 3:
                        tf = Typeface.createFromAsset(mgr,"heiti.otf");
                        binding.yangshiText.setTypeface(tf);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return createDBS.size();
    }
}
