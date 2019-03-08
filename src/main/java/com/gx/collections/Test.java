package com.gx.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author gx
 * @ClassName: Test
 * @Description: java类作用描述
 * @date 2019/2/11 16:19
 * @Version: 1.0
 * @since
 */
public class Test {
    public static void main(String[] args) {
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.add("8");
        hashSet.add("9");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.stream().forEach(System.out::println);
        //LinkedHashSet
        hashSet=new LinkedHashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.add("8");
        hashSet.add("9");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.stream().forEach(System.out::println);
    }
}
