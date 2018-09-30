package com.chen1144.hviewer.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.util.function.Function;

public class Element2Element implements Serializable, Function<Element, Elements> {
    private String selector;

    @Override
    public Elements apply(Element source){
        return apply(source, selector);
    }

    static Elements apply(Element source, String selector){
        if(selector == null){
            return new Elements(source);
        }else{
            return source.select(selector);
        }
    }
}
