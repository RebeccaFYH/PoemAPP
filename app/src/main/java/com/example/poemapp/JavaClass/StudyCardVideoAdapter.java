package com.example.poemapp.JavaClass;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poemapp.Database.MiniClassDB;
import com.example.poemapp.R;

import java.util.List;

/**
 * Created by dell on 2019/4/24.
 */

public class StudyCardVideoAdapter extends RecyclerView.Adapter<StudyCardVideoAdapter.ViewHolder>{
    //声明
    private List<MiniClassDB> miniClassDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView video_image;
        TextView video_title;


        public ViewHolder(View itemView) {
            super(itemView);
            video_image = (ImageView)itemView.findViewById(R.id.minivideo);
            video_title = (TextView)itemView.findViewById(R.id.minivideo_title);
        }
    }

    //构造方法
    public StudyCardVideoAdapter(List<MiniClassDB> miniClassDBList,Context context){
        miniClassDBS = miniClassDBList;
        mcontext = context;
    }

    @Override
    public StudyCardVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_study_minvideo,parent,false);
        StudyCardVideoAdapter.ViewHolder holder = new StudyCardVideoAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MiniClassDB miniClassDB = miniClassDBS.get(position);
        holder.video_image.setImageResource(miniClassDB.getImageID());
        holder.video_title.setText(miniClassDB.getVideoTitle());
    }

    @Override
    public int getItemCount() {
        return miniClassDBS.size();
    }


}
