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

import java.util.List;

public class NavPeoFriendsAdapter extends  RecyclerView.Adapter< NavPeoFriendsAdapter.ViewHolder> {
    //声明
    private List<PostDB> postDBS;
    Context mcontext;

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView navPeoFri_image;
        TextView navPeoFri_user;



        public ViewHolder(View itemView) {
            super(itemView);
            navPeoFri_image = (ImageView)itemView.findViewById(R.id.friend_user_image);
            navPeoFri_user = (TextView)itemView.findViewById(R.id.friend_user_name);
        }
    }

    //构造方法
    public  NavPeoFriendsAdapter(List<PostDB> postDBList,Context context){
        postDBS = postDBList;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_navpeo,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostDB postDB = postDBS.get(position);
        holder.navPeoFri_user.setText(postDB.getUserName());
        holder.navPeoFri_image.setImageResource(R.mipmap.icon_image);
    }

    @Override
    public int getItemCount() {
        return postDBS.size();
    }
}
