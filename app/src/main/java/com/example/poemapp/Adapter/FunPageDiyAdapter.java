package com.example.poemapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Database.UserMakeDB;
import com.example.poemapp.R;

import java.util.List;

public class FunPageDiyAdapter extends RecyclerView.Adapter<FunPageDiyAdapter.ViewHolder>  {
    //声明
    private List<UserMakeDB> userMakeDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView diy_image;

        public ViewHolder(View itemView) {
            super(itemView);
            diy_image = (ImageView)itemView.findViewById(R.id.fun_diybg);
        }
    }

    //构造方法
    public FunPageDiyAdapter(List<UserMakeDB> userMakeDBList, Context context){
        userMakeDBS = userMakeDBList;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_fun_diy,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserMakeDB userMakeDB = userMakeDBS.get(position);
        holder.diy_image.setImageResource(userMakeDB.getDiyBackground());

    }

    @Override
    public int getItemCount() {
        return userMakeDBS.size();
    }
}
