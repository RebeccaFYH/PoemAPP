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

public class NavMyWorksAdapter extends  RecyclerView.Adapter<NavMyWorksAdapter.ViewHolder> {
        //声明
        private List<PostDB> postDBS;
        Context mcontext;

        //内部类ViewHolder，避免重复加载布局
        static class ViewHolder extends RecyclerView.ViewHolder {
            //声明
            ImageView navWorks_titleimage;
            TextView navWorks_title;
            TextView navWorks_contents;

            public ViewHolder(View itemView) {
                super(itemView);
                navWorks_titleimage = (ImageView)itemView.findViewById(R.id.navWorks_bg_icon);
                navWorks_title = itemView.findViewById(R.id.navworks_title);
                navWorks_contents = itemView.findViewById(R.id.navworks_text);
            }
        }

        //构造方法
        public NavMyWorksAdapter(List<PostDB> postDBList,Context context){
            postDBS = postDBList;
            mcontext = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.rv_myworks,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(com.example.poemapp.Adapter.NavMyWorksAdapter.ViewHolder holder, int position) {
            PostDB postDB = postDBS.get(position);
            holder.navWorks_contents.setText(postDB.getPostContent());
            holder.navWorks_title.setText(postDB.getUserName());
            holder. navWorks_titleimage.setImageResource(R.mipmap.icon_image);
        }

        @Override
        public int getItemCount() {
            return postDBS.size();
        }
    }

