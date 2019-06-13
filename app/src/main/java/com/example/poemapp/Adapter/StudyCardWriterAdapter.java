package com.example.poemapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Activity.ReadPoemActivity;
import com.example.poemapp.Database.CollectRelativeDB;
import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.R;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2019/3/26.
 */

public class StudyCardWriterAdapter extends RecyclerView.Adapter<StudyCardWriterAdapter.ViewHolder> {
    //声明
    private static final int N = 19;
    private List<PoemDB> mwriterDBList;
    private List<CollectRelativeDB> collectRelativeDBList = new ArrayList<CollectRelativeDB>();

    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView writer_icon;
        ToggleButton collect;

        public ViewHolder(View itemView) {
            super(itemView);
            writer_icon = (ImageView)itemView.findViewById(R.id.writer_icon);
            collect = itemView.findViewById(R.id.tb1);
        }
    }

    //构造方法
    public StudyCardWriterAdapter(List<PoemDB> writerDBList,Context context){
        mwriterDBList = writerDBList;
        mcontext = context;

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
        Random rand = new Random();
        final int randNum = rand.nextInt(N);
        PoemDB poemDB = mwriterDBList.get(randNum);
        holder.writer_icon.setImageResource(poemDB.getPoemImageID());
        holder.itemView.setTag(position);//设置标签


        //点击事件
        holder.writer_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, ReadPoemActivity.class);
                intent.putExtra("poemId",randNum);
                mcontext.startActivity(intent);
            }
        });

        //收藏
        holder.collect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(mcontext,"收藏成功",
                        Toast.LENGTH_SHORT).show();
                    //更新联系集表
                    CollectRelativeDB collectRelativeDB = new CollectRelativeDB();
                    collectRelativeDB.setPoemID(randNum);
                    collectRelativeDB.save();

                    PoemDB poemDB1 = new PoemDB();
                    poemDB1.setCollect("true");
                    poemDB1.updateAll("poemID = ?", String.valueOf(randNum));
                    Log.d("StudyCardWriterAdapter", poemDB.getCollect());
                }else {
                    Toast.makeText(mcontext,"取消收藏",
                            Toast.LENGTH_SHORT).show();
                    //更新联系基表（删除
                    LitePal.deleteAll(CollectRelativeDB.class,"poemID = ?", String.valueOf(randNum));

                    PoemDB poemDB2 = new PoemDB();
                    poemDB2.setCollect("false");
                    poemDB2.updateAll("poemID = ?", String.valueOf(randNum));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mwriterDBList.size();
    }


}
