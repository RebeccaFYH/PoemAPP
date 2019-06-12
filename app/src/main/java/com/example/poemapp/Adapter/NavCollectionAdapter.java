package com.example.poemapp.JavaClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import java.util.List;

public class NavCollectionAdapter extends  RecyclerView.Adapter< NavCollectionAdapter.ViewHolder> {
    //声明
    private List<PostDB> postDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        //ImageView navCollectionTrue_image;
        TextView navCollection_title;
        TextView Collection_msg_post_content;
        public ViewHolder(View itemView) {
            super(itemView);
            //navCollectionTrue_image = (ImageView)itemView.findViewById(R.id.shoucang1);
            navCollection_title = itemView.findViewById(R.id.Collection_titlename);
            Collection_msg_post_content = itemView.findViewById(R.id.Collection_msg_post_content);
        }
    }

    //构造方法
    public  NavCollectionAdapter(List<PostDB> postDBList,Context context){
        postDBS = postDBList;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_navmsgfriend,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostDB postDB = postDBS.get(position);
        holder.navCollection_title.setText(postDB.getUserName());
        //holder.navMsgFri_image.setImageResource(R.mipmap.icon_image);
    }

    @Override
    public int getItemCount() {
        return postDBS.size();
    }
}
