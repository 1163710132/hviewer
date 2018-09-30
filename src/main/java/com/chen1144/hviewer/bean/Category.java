package com.chen1144.hviewer.bean;

import com.chen1144.hviewer.selector.IndexRule;
import com.chen1144.hviewer.util.Text2Text;

import java.util.List;
import java.util.Map;

public class Category {
    private String cid;
    private String title;
    private IndexRule indexRule;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IndexRule getIndexRule() {
        return indexRule;
    }

    public void setIndexRule(IndexRule indexRule) {
        this.indexRule = indexRule;
    }
}
