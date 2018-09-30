package com.chen1144.hviewer.bean;

import java.util.List;

public class Page {
    private int index;
    private String url;
    private List<String> galleries;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<String> galleries) {
        this.galleries = galleries;
    }
}
