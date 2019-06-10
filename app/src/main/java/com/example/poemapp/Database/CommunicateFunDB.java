package com.example.poemapp.Database;

import org.litepal.crud.LitePalSupport;

public class CommunicateFunDB extends LitePalSupport {
    private String funLabel;
    private String funTitle;

    public String getFunLabel() {
        return funLabel;
    }

    public void setFunLabel(String funLabel) {
        this.funLabel = funLabel;
    }

    public String getFunTitle() {
        return funTitle;
    }

    public void setFunTitle(String funTitle) {
        this.funTitle = funTitle;
    }
}
