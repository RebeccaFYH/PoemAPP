package com.example.poemapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Activity.ReadPoemActivity;
import com.example.poemapp.Database.CollectRelativeDB;
import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import java.util.List;

public class NavCollectionAdapter extends  RecyclerView.Adapter< NavCollectionAdapter.ViewHolder> {
    //声明
    private List<PoemDB> poemDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        TextView navCollection_title;
        TextView Collection_keyword;
        public ViewHolder(View itemView) {
            super(itemView);
            navCollection_title = itemView.findViewById(R.id.Collection_titlename);
            Collection_keyword = itemView.findViewById(R.id.Collection_keyword);
        }
    }

    //构造方法
    public  NavCollectionAdapter(List<PoemDB> poemDBList, Context context){
        poemDBS = poemDBList;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_shoucang,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PoemDB poemDB = poemDBS.get(position);
        holder.navCollection_title.setText(poemDB.getPoemName());
        holder.Collection_keyword.setText(poemDB.getPoemKeyWord());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, ReadPoemActivity.class);
                intent.putExtra("poemId",poemDB.getPoemID());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return poemDBS.size();
    }
}
