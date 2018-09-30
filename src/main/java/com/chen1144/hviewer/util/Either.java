package com.chen1144.hviewer.util;

import java.util.Optional;

public class Either<A, B> {
    private A a;
    private B b;

    private Either(A a, B b){
        this.a = a;
        this.b = b;
    }

    public Optional<A> asA(){
        return Optional.ofNullable(a);
    }

    public Optional<B> asB(){
        return Optional.ofNullable(b);
    }

    public static <A, B> Either<A, B> ofA(A a){
        return new Either<>(a, null);
    }

    public static <A, B> Either<A, B> ofB(B b){
        return new Either<>(null, b);
    }
}
