package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author gx
 * @ClassName: DefaultTest
 * @Description: java类作用描述
 * @date 2019/4/17 13:38
 * @Version: 1.0
 * @since
 */
public class DefaultTest {
    static interface A{
        default String getName()
        {
            return "a";
        }
        void out();
    }

    static class B implements A{

        @Override
        public void out() {

        }
    }

    public static void main(String[] args) {
        Optional.of(new B().getName()).ifPresent(System.out::println);
        String s="1,2,3";
        Arrays.asList(s.split(",")).stream().map(ss->ss.length()).collect(Collectors.toList()).forEach(System.out::println);

        Arrays.asList(new Apple("red", 123), new Apple("yellow", 126))
                .stream().collect(Collectors.toMap(Apple::getColor, Apple::getWeight)).entrySet().forEach(e-> System.out.println(e.getKey()+"="+e.getValue()));

        Arrays.asList(new Apple("red", 123), new Apple("yellow", 126), new Apple("red", 123), new Apple("yellow", 126))
                .stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.summarizingLong(Apple::getWeight))).entrySet().forEach(System.out::println);

         Arrays.asList(new Apple("red", 123), new Apple("yellow", 126), new Apple("red", 123), new Apple("yellow", 126))
                .stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.mapping(Apple::getWeight,Collectors.toList()))).entrySet().forEach(System.out::println);

        Arrays.asList(new Apple("red", 123), new Apple("yellow", 126), new Apple("red", 123), new Apple("yellow", 126))
                .stream()
                .collect(Collectors.groupingBy(Apple::getColor, Collectors.reducing(0L,Apple::getWeight,(a1,a2)->a1+a2)))
                .entrySet().forEach(System.out::println);

    }
}
