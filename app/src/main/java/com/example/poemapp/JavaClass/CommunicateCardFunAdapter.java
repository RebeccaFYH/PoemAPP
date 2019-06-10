package com.example.poemapp.JavaClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Database.CommunicateFunDB;
import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import java.util.List;

public class CommunicateCardFunAdapter extends RecyclerView.Adapter<CommunicateCardFunAdapter.ViewHolder> {
    //声明
    private List<CommunicateFunDB> communicateFunDBS;
    Context context;

    public CommunicateCardFunAdapter(List<CommunicateFunDB> communicateFunDBList, Context mcontext) {
        communicateFunDBS =communicateFunDBList;
        context = mcontext;
    }

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        TextView rv_label;
        TextView rv_title;
        TextView rv_date;
        TextView rv_time;


        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_communicate_fun,parent,false);
        CommunicateCardFunAdapter.ViewHolder holder = new CommunicateCardFunAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //CommunicateFunDB communicateFunDB = communicateFunDBS.get(position);
        for (int i=1;i<10;i++){
            holder.rv_label.setText("诗词接龙");
            holder.rv_title.setText("顺接——“把酒问青天”");
            holder.rv_date.setText("2019.06.09");
            holder.rv_time.setText("10:19");
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
