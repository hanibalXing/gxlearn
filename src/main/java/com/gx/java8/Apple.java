package com.gx.java8;

import lombok.Data;

/**
 * Created by wangwenjun on 2016/10/12.
 */
@Data
public class Apple {

    private String color;
    private Integer weight;

    public Apple() {
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }


}
