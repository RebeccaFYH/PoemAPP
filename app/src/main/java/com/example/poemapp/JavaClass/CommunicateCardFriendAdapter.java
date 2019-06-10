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

public class CommunicateCardFriendAdapter extends RecyclerView.Adapter<CommunicateCardFriendAdapter.ViewHolder> {
    //声明
    private List<PostDB> postDBS;
    Context mcontext;

    //构造方法
    public CommunicateCardFriendAdapter(List<PostDB> postDBList, Context context) {
        postDBS = postDBList;
        mcontext = context;
    }

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView rv_image;
        TextView rv_userName;
        TextView rv_postContent;
        TextView rv_date;
        TextView rv_time;

        public ViewHolder(View itemView) {
            super(itemView);
            rv_image = (ImageView)itemView.findViewById(R.id.icon_image);
            rv_userName = itemView.findViewById(R.id.communicate_user_name);
            rv_postContent = itemView.findViewById(R.id.communicate_post_content);
            rv_date = itemView.findViewById(R.id.communicate_date);
            rv_time = itemView.findViewById(R.id.communicate_time);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_communicate_friend,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostDB postDB = postDBS.get(position);
        holder.rv_userName.setText(postDB.getUserName());
        holder.rv_postContent.setText(postDB.getPostContent());
        holder.rv_date.setText("2019.06.09");
        holder.rv_time.setText("10:19");
    }

    @Override
    public int getItemCount() {
        return postDBS.size();
    }
}
