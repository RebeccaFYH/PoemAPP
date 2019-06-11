package com.example.poemapp.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poemapp.Database.CreateDB;
import com.example.poemapp.R;

import java.util.List;

/**
 * Created by dell on 2019/4/29.
 */

public class CreateCardPBAdapter extends RecyclerView.Adapter<CreateCardPBAdapter.ViewHolder> {
    //声明
    private List<CreateDB> createDBS;
    Context mcontext;
    TextView textView,textView1;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView pb_image;

        public ViewHolder(View itemView) {
            super(itemView);
            pb_image = (ImageView)itemView.findViewById(R.id.create_pb);
        }
    }

    //构造方法
    public CreateCardPBAdapter(List<CreateDB> createDBList,
                               Context context, TextView yangshiText,TextView paibanText){
        createDBS = createDBList;
        mcontext = context;
        textView = yangshiText;
        textView1 = paibanText;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_paiban,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CreateDB createDB = createDBS.get(position);
        holder.pb_image.setImageResource(createDB.getCreatePBImageID());

        //点击事件
        holder.pb_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        textView.setGravity(Gravity.RIGHT);
                        textView1.setGravity(Gravity.RIGHT);
                        break;
                    case 1:
                        textView.setGravity(Gravity.LEFT|Gravity.BOTTOM);
                        textView1.setGravity(Gravity.LEFT|Gravity.BOTTOM);
                        break;
                    case 2:
                        textView.setGravity(Gravity.CENTER);
                        textView1.setGravity(Gravity.CENTER);
                        break;
                    case 3:
                        textView.setGravity(Gravity.LEFT);
                        textView1.setGravity(Gravity.LEFT);
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
