package com.example.poemapp.JavaClass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class CreateCardRWAdapter extends RecyclerView.Adapter<CreateCardRWAdapter.ViewHolder>{
    //声明
    private List<CreateDB> createDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView rw_image;

        public ViewHolder(View itemView) {
            super(itemView);
            rw_image = (ImageView)itemView.findViewById(R.id.peitu_rw_imageview);
        }
    }

    //构造方法
    public CreateCardRWAdapter(List<CreateDB> createDBList,Context context){
        createDBS = createDBList;
        mcontext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_renwu,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CreateDB createDB = createDBS.get(position);
        holder.rw_image.setImageResource(createDB.getCreateRWImageID());
    }

    @Override
    public int getItemCount() {
        return createDBS.size();
    }
}
