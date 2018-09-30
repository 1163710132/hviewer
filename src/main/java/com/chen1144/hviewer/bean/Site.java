package com.chen1144.hviewer.bean;

import com.chen1144.hviewer.selector.GalleryRule;
import com.chen1144.hviewer.selector.SiteRule;
import com.chen1144.hviewer.service.PictureDownloader;
import com.chen1144.hviewer.util.Box;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Site {
    private SiteRule siteRule;
    private List<Category> categories;
    private Map<String, Box<Gallery>> loadedGalleries;

    private Site(){}

    public static Site load(SiteRule siteRule){
        Site site = new Site();
        site.siteRule = siteRule;
        site.categories = siteRule.getCategories();
        site.loadedGalleries = new HashMap<>();
        return site;
    }

    public Box<Gallery> getGallery(String gid, Consumer<Gallery> consumer){
        if(loadedGalleries.containsKey(gid)){
            return loadedGalleries.get(gid);
        }else{
            synchronized (this){
                if(!loadedGalleries.containsKey(gid)){
                    final Box<Gallery> gallery = loadGallery(gid);
                    loadedGalleries.put(gid, gallery);
                    return gallery;
                }else{
                    return loadedGalleries.get(gid);
                }
            }
        }
    }

    public Box<Gallery> loadGallery(String gid){
        GalleryRule galleryRule = siteRule.getGalleryRule();
        String url = galleryRule.getUrlFormat().apply(gid);
        Box<Gallery> box = new Box<>();
        new Thread(()->{
            Connection connection = HttpConnection.connect(url)
                    .method(Connection.Method.GET);
            try {
                Document document = connection.get();
                Gallery gallery = new Gallery();
                gallery.setGid(gid);
                gallery.setUrl(url);
                gallery.setTitle(galleryRule.getTitle().apply(document).get(0));
                gallery.setCover(galleryRule.getCover().apply(document).get(0));
                gallery.setDatetime(galleryRule.getDatetime().apply(document).get(0));
                gallery.setDescription(galleryRule.getDescription().apply(document).get(0));
                gallery.setRating(galleryRule.getRating().apply(document).get(0));
                gallery.setUploader(galleryRule.getUploader().apply(document).get(0));
                gallery.setTags(galleryRule.getTags().apply(document));
                /*{
                    List<Picture> pictures = new ArrayList<>();
                    galleryRule.getItems().apply(document).forEach(item -> {
                        Picture picture = new Picture();
                        picture.setPid(pictures.size());
                        pictures.add(picture);
                    });
                    gallery.setPictures(pictures);
                }*/
                gallery.setPictures(new ArrayList<>());
                box.setValue(gallery);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }).start();
        return box;
    }

    public IndexPage getCategoryIndexPage(Category category){
        Connection connection = HttpConnection.connect(category.getIndexRule().getUrl().apply(category.getIndexRule().getFirstPage().toString()))
                .method(Connection.Method.GET);
        try {
            Document document = connection.get();
            IndexPage indexPage = new IndexPage();
            indexPage.setUrl(category.getIndexRule().getUrl());
            String pageCountString = category.getIndexRule().getPageCount().apply(document).get(0);
            int pageCount = Integer.parseInt(pageCountString);
            {
                ArrayList<Page> arrayList = new ArrayList<>();
                IntStream.range(0, pageCount).forEach(i -> arrayList.add(null));
                indexPage.setPages(arrayList);
            }
            Page page = new Page();
            page.setIndex(0);
            page.setUrl(category.getIndexRule().getUrl().apply("0"));
            page.setGalleries(siteRule.getGalleryRule().getItems().apply(document));
            indexPage.getPages().set(0, page);
            return indexPage;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
