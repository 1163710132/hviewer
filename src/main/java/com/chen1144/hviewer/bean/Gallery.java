package com.chen1144.hviewer.bean;

import com.chen1144.hviewer.service.PictureDownloader;
import com.chen1144.hviewer.util.Either;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;

public class Gallery {
    private String gid;
    private String url;
    private String title;
    private String uploader;
    private String cover;
    private String datetime;
    private String rating;
    private String description;
    private List<String> tags;
    private List<Picture> pictures;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public synchronized Picture getPicture(int pid){
        while (pictures.size() <= pid){
            pictures.add(null);
        }
        if(pictures.get(pid) == null){
            Picture picture = new Picture();
            picture.setPid(pid);
            pictures.set(pid, picture);
            return picture;
        }
        return pictures.get(pid);
    }
}
