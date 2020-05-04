package com.gx.java8;

import java.util.function.Consumer;
import java.util.function.Function;

public class Table {
    public void lock(String s, Consumer<String> consumer  ) {
        lockToUpdate(s,s1 -> {
            System.out.println(s1);
            consumer.accept(s1);
            return null;
        });
    }

    public void lockToUpdate(String s, Function<String,String> updateer) {

        String s1="123"+s;
        String apply = updateer.apply(s1);
        //System.out.printf(apply);
    }
}
