package com.example.poemapp.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poemapp.Database.PostDB;
import com.example.poemapp.R;

import java.io.File;
import java.util.List;

public class NavMyIntonationAdapter extends RecyclerView.Adapter< NavMyIntonationAdapter.ViewHolder> {
    //声明
    private List<PostDB> postDBS;
    Context mcontext;


    private boolean isPause=false;//是否暂停
    private MediaPlayer mediaPlayer = new MediaPlayer();//MediaPlayer对象
    private File file;//要播放的文件

    //内部类ViewHolder，避免重复加载布局
    static class ViewHolder extends RecyclerView.ViewHolder {
        //声明
        ImageView navMyIntonation_image;
        TextView navMyIntonation_user;

        Button button;
        Button button1;
        Button button2;


        public ViewHolder(View itemView) {
            super(itemView);
            navMyIntonation_image = (ImageView) itemView.findViewById(R.id.innovation_users_images);
            navMyIntonation_user = itemView.findViewById(R.id.innovation_users_name);

            button = (Button) itemView.findViewById(R.id.innovation_listen);//播放
            button1 = (Button) itemView.findViewById(R.id.stop);//暂停
            button1 = (Button) itemView.findViewById(R.id.play);//暂停


        }
    }




    //构造方法
    public  NavMyIntonationAdapter(List<PostDB> postDBList,Context context){
        postDBS = postDBList;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_intonation,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostDB postDB = postDBS.get(position);
        holder.navMyIntonation_user.setText(postDB.getUserName());
        holder.navMyIntonation_image.setImageResource(R.mipmap.icon_image);

        if(!isFileExist()){
            holder.button.setEnabled(false);
        }

        //对MediaPlayer对象添加事件监听，当播放完成时重新开始音乐播放
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                play();
            }
        });

        //对播放按钮进行事件监听

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                play();

                if(isPause){
                    holder.button1.setText("暂停");
                    isPause=false;
                }
                holder.button1.setEnabled(true);
                holder.button2.setEnabled(true);
                holder.button.setEnabled(false);
            }

        });

        //对暂停、继续按钮添加事件监听器

        holder.button1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(mediaPlayer.isPlaying()&&!isPause){
                    mediaPlayer.pause();
                    isPause=true;
                    ((Button)v).setText("继续");
                    holder.button.setEnabled(true);
                }else{
                    mediaPlayer.start();
                    ((Button)v).setText("暂停");
                    holder.button.setEnabled(false);
                }
            }

        });
//        //对停止按钮添加事件监听器
//        holder.button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                mediaPlayer.stop();
//
//                holder.button1.setEnabled(false);
//                holder.button2.setEnabled(false);
//                holder.button.setEnabled(true);
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return postDBS.size();
    }


    //判断文件是否存在
    private boolean  isFileExist(){

        file=new File("android.resource://" + mcontext.getPackageName() + "/" + R.raw.tjsqs);

        if(file.exists()){

//              mediaPlayer=new MediaPlayer();

            mediaPlayer=MediaPlayer.create(mcontext,R.raw.tjsqs);

            try {

//                mediaPlayer.setDataSource(file.getAbsolutePath());
//
//
//                mediaPlayer.prepare();//预加载音频
//
//                mediaPlayer.start();//播放音乐

            }catch (Exception e) {

                e.printStackTrace();

            }



            return true;

        }else{


        }

        return false;

    }

    //播放音乐的方法
    private void play(){
        try{
            mediaPlayer.reset();//从新设置要播放的音乐
            mediaPlayer=MediaPlayer.create(mcontext,R.raw.tjsqs);
            mediaPlayer.start();//播放音乐
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ;
    }

}
