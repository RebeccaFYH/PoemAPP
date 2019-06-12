package com.example.poemapp.Adapter;

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

import org.litepal.LitePal;

import java.util.List;

public class NavMsgFriendsAdapter extends  RecyclerView.Adapter< NavMsgFriendsAdapter.ViewHolder> {
    //声明
    private List<PostDB> postDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView navMsgFri_image;
        TextView navMsgFri_user;

        public ViewHolder(View itemView) {
            super(itemView);
            navMsgFri_image = (ImageView)itemView.findViewById(R.id.msg_user_icon);
            navMsgFri_user = itemView.findViewById(R.id.msg_user_name);
        }
    }

    //构造方法
    public  NavMsgFriendsAdapter(List<PostDB> postDBList,Context context){
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
        holder.navMsgFri_user.setText(postDB.getUserName());
        holder.navMsgFri_image.setImageResource(R.mipmap.icon_image);
    }

    @Override
    public int getItemCount() {
        return postDBS.size();
    }
}
