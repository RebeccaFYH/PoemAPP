package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**帖子信息
 * Created by dell on 2019/3/21.
 */

public class PostDB extends LitePalSupport {
    private String userName;
    private String postContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
