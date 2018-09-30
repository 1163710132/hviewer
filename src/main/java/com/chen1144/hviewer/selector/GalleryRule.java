package com.chen1144.hviewer.selector;

import com.chen1144.hviewer.util.Element2Text;
import com.chen1144.hviewer.util.Text2Text;

public class GalleryRule {
    private Text2Text urlFormat;
    private Element2Text items;
    private Element2Text title;
    private Element2Text uploader;
    private Element2Text cover;
    private Element2Text datetime;
    private Element2Text rating;
    private Element2Text description;
    private Element2Text tags;
    private Text2Text images;

    public Text2Text getUrlFormat() {
        return urlFormat;
    }

    public void setUrlFormat(Text2Text urlFormat) {
        this.urlFormat = urlFormat;
    }

    public Element2Text getItems() {
        return items;
    }

    public void setItems(Element2Text items) {
        this.items = items;
    }

    public Element2Text getTitle() {
        return title;
    }

    public void setTitle(Element2Text title) {
        this.title = title;
    }

    public Element2Text getUploader() {
        return uploader;
    }

    public void setUploader(Element2Text uploader) {
        this.uploader = uploader;
    }

    public Element2Text getCover() {
        return cover;
    }

    public void setCover(Element2Text cover) {
        this.cover = cover;
    }

    public Element2Text getDatetime() {
        return datetime;
    }

    public void setDatetime(Element2Text datetime) {
        this.datetime = datetime;
    }

    public Element2Text getRating() {
        return rating;
    }

    public void setRating(Element2Text rating) {
        this.rating = rating;
    }

    public Element2Text getDescription() {
        return description;
    }

    public void setDescription(Element2Text description) {
        this.description = description;
    }

    public Element2Text getTags() {
        return tags;
    }

    public void setTags(Element2Text tags) {
        this.tags = tags;
    }

    public Text2Text getImages() {
        return images;
    }

    public void setImages(Text2Text images) {
        this.images = images;
    }
}
