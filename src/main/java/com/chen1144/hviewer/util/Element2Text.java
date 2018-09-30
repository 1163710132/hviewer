package com.chen1144.hviewer.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Element2Text implements Serializable, Function<Element, List<String>> {
    private String selector;
    private String regex;
    private String format;


    @Override
    public List<String> apply(Element element) {
        return apply(element, selector, regex, format);
    }

    static List<String> apply(Element element, String selector, String regex, String format){
        Elements elements = selector != null ? element.select(selector) : new Elements(element);
        Stream<String> rawStream = regex == null ? Stream.of(element.html()) : elements.stream().map(
            new Function<Element, Optional<String>>() {
                final Pattern pattern = Pattern.compile(regex);
                @Override
                public Optional<String> apply(Element element) {
                    Matcher matcher = pattern.matcher(element.html());
                    Optional<String> optional = matcher.find() ? Optional.of(matcher.group()) : Optional.empty();
                    return optional;
                }
            }
        ).filter(Optional::isPresent).map(Optional::get);
        Stream<String> stream = format == null ? rawStream : rawStream.map(string -> String.format(format, string));
        return stream.collect(Collectors.toList());
    }
}
