package com.chen1144.hviewer.selector;

import com.chen1144.hviewer.bean.Category;
import com.chen1144.hviewer.util.Element2Element;
import com.chen1144.hviewer.util.Element2Text;

import java.util.List;

public class SiteRule {
    private String sid;
    private String title;
    private GalleryRule galleryRule;
    private ImgRule imgRule;
    private List<Category> categories;
    private GallerySelector gallerySelector;
    private SearchRule searchRule;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GalleryRule getGalleryRule() {
        return galleryRule;
    }

    public void setGalleryRule(GalleryRule galleryRule) {
        this.galleryRule = galleryRule;
    }

    public ImgRule getImgRule() {
        return imgRule;
    }

    public void setImgRule(ImgRule imgRule) {
        this.imgRule = imgRule;
    }

    public SearchRule getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(SearchRule searchRule) {
        this.searchRule = searchRule;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public GallerySelector getGallerySelector() {
        return gallerySelector;
    }

    public void setGallerySelector(GallerySelector gallerySelector) {
        this.gallerySelector = gallerySelector;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
