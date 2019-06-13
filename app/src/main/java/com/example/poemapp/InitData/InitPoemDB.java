package com.example.poemapp.InitData;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.poemapp.Database.PoemDB;
import com.example.poemapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dell on 2019/4/9.
 */

public class InitPoemDB {
    PoemDB poemDB[] = new PoemDB[30];

    public InitPoemDB(Context context) throws IOException {
        try {
            init(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(Context context) throws IOException {
        //创建输入流对象
        AssetManager am = context.getAssets();

        InputStream istrPoemName = am.open("poemName.txt");
        InputStream istrPoemContent = am.open("poemContent.txt");
        InputStream istrPoemKeyword = am.open("poemKeyword.txt");
        InputStream istrPoemTranslation = am.open("poemTranslation.txt");
        InputStream istrPoemZhushi = am.open("poemZhushi.txt");
        InputStream istrPoemTopic = am.open("poemTopic.txt");
        InputStream istrPoemStyle = am.open("poemStyle.txt");
        InputStream istrPoemPai = am.open("poemPai.txt");
        InputStream istrPoemIntroduce = am.open("writerIntroduce.txt");
        InputStream istrPoemLife= am.open("writerLife.txt");

        //缓冲区对象，读取
        BufferedReader bfPoemName = new BufferedReader(new InputStreamReader(istrPoemName));
        BufferedReader bfPoemContent = new BufferedReader(new InputStreamReader(istrPoemContent));
        BufferedReader bfPoemKeyword = new BufferedReader(new InputStreamReader(istrPoemKeyword));
        BufferedReader bfPoemTranslation = new BufferedReader(new InputStreamReader(istrPoemTranslation));
        BufferedReader bfPoemZhushi = new BufferedReader(new InputStreamReader(istrPoemZhushi));
        BufferedReader bfPoemTopic = new BufferedReader(new InputStreamReader(istrPoemTopic));
        BufferedReader bfPoemStyle = new BufferedReader(new InputStreamReader(istrPoemStyle));
        BufferedReader bfPoemPai = new BufferedReader(new InputStreamReader(istrPoemPai));
        BufferedReader bfWriterIntroduce = new BufferedReader(new InputStreamReader(istrPoemIntroduce));
        BufferedReader bfWriterLife = new BufferedReader(new InputStreamReader(istrPoemLife));

        //获取的信息
        String linePoemName;
        String linePoemContent;
        String linePoemKeyWord;
        String linePoemTranslation;
        String linePoemZhushi;
        String linePoemTopic;
        String linePoemStyle;
        String linePoemPai;
        String linePoemIntroduce;
        String linePoemLife;

        linePoemName = bfPoemName.readLine();
        linePoemContent = bfPoemContent.readLine();
        linePoemKeyWord = bfPoemKeyword.readLine();
        linePoemTranslation = bfPoemTranslation.readLine();
        linePoemZhushi = bfPoemZhushi.readLine();
        linePoemTopic = bfPoemTopic.readLine();
        linePoemStyle = bfPoemStyle.readLine();
        linePoemPai = bfPoemPai.readLine();
        linePoemIntroduce = bfWriterIntroduce.readLine();
        linePoemLife = bfWriterLife.readLine();

        for (int i=0;linePoemName !=null;i++){
            poemDB[i] = new PoemDB();
            poemDB[i].setPoemID(i);
            poemDB[i].setPoemName(linePoemName);
            poemDB[i].setPoemContent(linePoemContent);
            poemDB[i].setPoemKeyWord(linePoemKeyWord);
            poemDB[i].setPoemTranslation(linePoemTranslation);
            poemDB[i].setPoemZhushi(linePoemZhushi);
            poemDB[i].setPoemTopic(linePoemTopic);
            poemDB[i].setPoemStyle(linePoemStyle);
            poemDB[i].setPoemPai(linePoemPai);
            poemDB[i].setCollect("false");
            poemDB[i].setPoemAppreciation(linePoemLife);
            poemDB[i].setPoemCreateBackgrond(linePoemIntroduce);
            poemDB[i].save();

            //往下读
            linePoemName = bfPoemName.readLine();
            linePoemContent = bfPoemContent.readLine();
            linePoemKeyWord = bfPoemKeyword.readLine();
            linePoemTranslation = bfPoemTranslation.readLine();
            linePoemZhushi = bfPoemZhushi.readLine();
            linePoemTopic = bfPoemTopic.readLine();
            linePoemStyle = bfPoemStyle.readLine();
            linePoemPai = bfPoemPai.readLine();
            linePoemIntroduce = bfWriterIntroduce.readLine();
            linePoemLife = bfWriterLife.readLine();
        }

        initPoemImageID();
    }

    private void initPoemImageID() {
        poemDB[0].setPoemImageID(R.drawable.bg_qiwu);
        poemDB[0].save();
        poemDB[1].setPoemImageID(R.drawable.bg_buzhilushan);
        poemDB[1].save();
        poemDB[2].setPoemImageID(R.drawable.bg_fengji);
        poemDB[2].save();
        poemDB[3].setPoemImageID(R.drawable.bg_jutou);
        poemDB[3].save();
        poemDB[4].setPoemImageID(R.drawable.bg_modao);
        poemDB[4].save();
        poemDB[5].setPoemImageID(R.drawable.bg_yizhan);
        poemDB[5].save();
        poemDB[6].setPoemImageID(R.drawable.bg_shanyou);
        poemDB[6].save();
        poemDB[7].setPoemImageID(R.drawable.bg_ruosi);
        poemDB[7].save();
        poemDB[8].setPoemImageID(R.drawable.bg_shenji);
        poemDB[8].save();
        poemDB[9].setPoemImageID(R.drawable.bg_sishi);
        poemDB[9].save();
        poemDB[10].setPoemImageID(R.drawable.bg_jiangshan);
        poemDB[10].save();
        poemDB[11].setPoemImageID(R.drawable.bg_shanbuyangao);
        poemDB[11].save();
        poemDB[12].setPoemImageID(R.drawable.bg_xiyang);
        poemDB[12].save();
        poemDB[13].setPoemImageID(R.drawable.bg_biou);
        poemDB[13].save();
        poemDB[14].setPoemImageID(R.drawable.bg_xiaogu);
        poemDB[14].save();
        poemDB[15].setPoemImageID(R.drawable.bg_cengjing);
        poemDB[15].save();
        poemDB[16].setPoemImageID(R.drawable.bg_wantou);
        poemDB[16].save();
        poemDB[17].setPoemImageID(R.drawable.bg_hexinyoulu);
        poemDB[17].save();
        poemDB[18].setPoemImageID(R.drawable.bg_jidu);
        poemDB[18].save();
        poemDB[19].setPoemImageID(R.drawable.bg_yejing);
        poemDB[19].save();



    }
}
