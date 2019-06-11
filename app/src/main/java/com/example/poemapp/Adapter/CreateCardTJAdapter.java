package com.example.poemapp.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poemapp.Database.CreateDB;
import com.example.poemapp.R;

import java.util.List;

/**
 * Created by dell on 2019/4/30.
 */

public class CreateCardTJAdapter extends RecyclerView.Adapter<CreateCardTJAdapter.ViewHolder>{
    //声明
    private List<CreateDB> createDBS;
    Context mcontext;
    TextView textView;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView tj_image;

        public ViewHolder(View itemView) {
            super(itemView);
            tj_image = (ImageView)itemView.findViewById(R.id.peitu_tj_imageview);
        }
    }

    //构造方法
    public CreateCardTJAdapter(List<CreateDB> createDBList, Context context, TextView peituText){
        createDBS = createDBList;
        mcontext = context;
        textView = peituText;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_tuijian,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CreateDB createDB = createDBS.get(position);
        holder.tj_image.setImageResource(createDB.getCreateBGImageID());

        //点击事件
        holder.tj_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        textView.setBackgroundResource(createDBS.get(0).getCreateBGImageID());
                        break;
                    case 1:
                        textView.setBackgroundResource(createDBS.get(1).getCreateBGImageID());
                        break;
                    case 2:
                        textView.setBackgroundResource(createDBS.get(2).getCreateBGImageID());
                        break;
                    case 3:
                        textView.setBackgroundResource(createDBS.get(3).getCreateBGImageID());
                        break;
                    case 4:
                        textView.setBackgroundResource(createDBS.get(4).getCreateBGImageID());
                        break;
                    case 5:
                        textView.setBackgroundResource(createDBS.get(5).getCreateBGImageID());
                        break;
                    case 6:
                        textView.setBackgroundResource(createDBS.get(6).getCreateBGImageID());
                        break;
                    case 7:
                        textView.setBackgroundResource(createDBS.get(7).getCreateBGImageID());
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
