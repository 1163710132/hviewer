package com.chen1144.hviewer.selector;

import com.chen1144.hviewer.util.Element2Element;
import com.chen1144.hviewer.util.Element2Text;
import com.chen1144.hviewer.util.Text2Text;

public class IndexRule {
    private GallerySelector gallerySelector;
    private Text2Text url;
    private Integer firstPage;
    private Element2Text pageCount;

    public GallerySelector getGallerySelector() {
        return gallerySelector;
    }

    public void setGallerySelector(GallerySelector gallerySelector) {
        this.gallerySelector = gallerySelector;
    }

    public Text2Text getUrl() {
        return url;
    }

    public void setUrl(Text2Text url) {
        this.url = url;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Element2Text getPageCount() {
        return pageCount;
    }

    public void setPageCount(Element2Text pageCount) {
        this.pageCount = pageCount;
    }
}
