package com.example.poemapp.JavaClass;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.Database.WriterDB;
import com.example.poemapp.R;

import java.util.List;

/**
 * Created by dell on 2019/3/26.
 */

public class StudyCardWriterAdapter extends RecyclerView.Adapter<StudyCardWriterAdapter.ViewHolder> {
    //声明
    private List<PoemDB> mwriterDBList;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView writer_icon;
        TextView writer_name;
        TextView writer_story;

        public ViewHolder(View itemView) {
            super(itemView);
            writer_icon = (ImageView)itemView.findViewById(R.id.writer_icon);
            writer_name = (TextView)itemView.findViewById(R.id.writer_name);
            writer_story = (TextView)itemView.findViewById(R.id.writer_story);
        }
    }

    //构造方法
    public StudyCardWriterAdapter(List<PoemDB> writerDBList){
        mwriterDBList = writerDBList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_study_tuijian_poemwriter,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PoemDB poemDB = mwriterDBList.get(position);
        holder.writer_icon.setImageResource(poemDB.getPoemID());
        holder.writer_name.setText(poemDB.getPoemName());
        holder.writer_story.setText(poemDB.getPoemCotent());
    }

    @Override
    public int getItemCount() {
        return mwriterDBList.size();
    }


}
