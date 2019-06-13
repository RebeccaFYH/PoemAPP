package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

/**
 * 收藏联系集
 */

public class CollectRelativeDB extends LitePalSupport {
    private int dataID;
    private int userID;
    private int poemID;

    public int getUserID() {
        return userID;
    }

    public int getPoemID() {
        return poemID;
    }

    public void setPoemID(int poemID) {
        this.poemID = poemID;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }
}
