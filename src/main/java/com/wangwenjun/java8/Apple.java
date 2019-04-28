package com.wangwenjun.java8;

import java.util.Objects;

/**
 * Created by wangwenjun on 2016/10/12.
 */
public class Apple {

    private String color;
    private long weight;
    private int sugar;

    public Apple() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;}
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apple apple = (Apple) o;
        return weight == apple.weight &&
                sugar == apple.sugar &&
                Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight, sugar);
    }

    public Apple(String color, long weight, int sugar) {
        this.color = color;
        this.weight = weight;
        this.sugar = sugar;
    }

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
        this.sugar = 0;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", sugar=" + sugar +
                '}';
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }


}
