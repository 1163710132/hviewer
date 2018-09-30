package com.chen1144.hviewer;

import com.chen1144.hviewer.bean.Gallery;
import com.chen1144.hviewer.bean.Site;
import com.chen1144.hviewer.selector.SiteRule;
import com.chen1144.hviewer.service.PictureDownloader;
import com.chen1144.hviewer.util.Box;

public class Main {
    static SiteRule DEFAULT_SITE_RULE;

    public static void main(String[] args) {
        Site site = Site.load(DEFAULT_SITE_RULE);
        PictureDownloader downloader = new PictureDownloader(10);
        Box<Gallery> gallery = site.loadGallery("aa");
        while (!gallery.hasValue()){
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        gallery.getValue().getPicture();
    }
}
