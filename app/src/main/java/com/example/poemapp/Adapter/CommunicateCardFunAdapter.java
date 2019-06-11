package com.example.poemapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Database.CommunicateFunDB;
import com.example.poemapp.R;

import java.util.List;

public class CommunicateCardFunAdapter extends RecyclerView.Adapter<CommunicateCardFunAdapter.ViewHolder> {
    //声明
    private List<CommunicateFunDB> communicateFunDBS;
    Context mcontext;

    //构造方法
    public CommunicateCardFunAdapter(List<CommunicateFunDB> communicateFunDBList, Context context) {
        communicateFunDBS = communicateFunDBList;
        mcontext = context;
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
            rv_label = itemView.findViewById(R.id.communicate_fun_leixing_label);
            rv_title = itemView.findViewById(R.id.communicate_fun_title);
            rv_date = itemView.findViewById(R.id.communicate_fun_date);
            rv_time = itemView.findViewById(R.id.communicate_fun_time);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_communicate_fun,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommunicateFunDB communicateFunDB = communicateFunDBS.get(position);
        holder.rv_label.setText(communicateFunDB.getFunLabel());
        holder.rv_title.setText(communicateFunDB.getFunTitle());
        holder.rv_date.setText("2019.06.09");
        holder.rv_time.setText("10:19");
    }

    @Override
    public int getItemCount() {
        return communicateFunDBS.size();
    }
}
