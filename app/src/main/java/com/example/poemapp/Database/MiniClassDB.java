package com.example.poemapp.Database;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

/**微课堂信息
 * Created by dell on 2019/3/21.
 */

public class MiniClassDB extends LitePalSupport{
    private int ImageID;
    private String videoTitle;

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoTitle() {
        return videoTitle;
    }
}
