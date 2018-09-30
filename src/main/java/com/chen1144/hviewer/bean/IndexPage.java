package com.chen1144.hviewer.bean;

import com.chen1144.hviewer.util.Text2Text;

import java.util.List;

public class IndexPage {
    private Text2Text url;
    private List<Page> pages;

    public Text2Text getUrl() {
        return url;
    }

    public void setUrl(Text2Text url) {
        this.url = url;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
