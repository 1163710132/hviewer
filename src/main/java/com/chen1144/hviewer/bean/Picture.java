package com.chen1144.hviewer.bean;

import com.chen1144.hviewer.util.Box;

public class Picture {
    private int pid;
    private Box<Image> content;
    private Box<Image> hiRes;
    private Box<Image> thumbnail;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Box<Image> getContent() {
        return content;
    }

    public void setContent(Box<Image> content) {
        this.content = content;
    }

    public Box<Image> getHiRes() {
        return hiRes;
    }

    public void setHiRes(Box<Image> hiRes) {
        this.hiRes = hiRes;
    }

    public Box<Image> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Box<Image> thumbnail) {
        this.thumbnail = thumbnail;
    }
}
