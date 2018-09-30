package com.chen1144.hviewer.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text2Text implements Serializable, Function<String, String> {
    private String regex;
    private String format;

    @Override
    public String apply(String s) {
        return apply(s, regex, format);
    }

    static public String apply(String s, String regex, String format){
        if(regex != null){
            Pattern pattern = Pattern.compile(regex);
            List<String> list = new ArrayList<>();
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()){
                list.add(matcher.group());
            }
            if(format != null){
                return String.format(format, list.toArray());
            }else{
                return list.size() > 0 ? list.get(0) : "";
            }
        }else{
            return format == null ? "" : String.format(format, s);
        }
    }
}
