package com.chen1144.hviewer.util;

public class Box<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasValue(){
        return value != null;
    }
}
