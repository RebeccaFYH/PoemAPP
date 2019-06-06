package com.example.poemapp.JavaClass;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.poemapp.Database.CreateDB;
import com.example.poemapp.R;

import java.util.List;

/**
 * Created by dell on 2019/4/30.
 */

public class CreateCardFJAdapter extends RecyclerView.Adapter<CreateCardFJAdapter.ViewHolder>{
    //声明
    private List<CreateDB> createDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView fj_image;

        public ViewHolder(View itemView) {
            super(itemView);
            fj_image = (ImageView)itemView.findViewById(R.id.peitu_fj_imageview);
        }
    }

    //构造方法
    public CreateCardFJAdapter(List<CreateDB> createDBList,Context context){
        createDBS = createDBList;
        mcontext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_fengjing,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CreateDB createDB = createDBS.get(position);
        holder.fj_image.setImageResource(createDB.getCreateFJImageID());
    }

    @Override
    public int getItemCount() {
        return createDBS.size();
    }
}
