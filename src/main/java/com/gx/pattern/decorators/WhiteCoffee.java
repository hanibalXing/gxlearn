package com.gx.pattern.decorators;

/**
 * @author gx
 * @ClassName: WhiteCoffee
 * @Description: java类作用描述
 * @date 2019/2/14 15:31
 * @Version: 1.0
 * @since
 */
public class WhiteCoffee implements Coffee {
    @Override
    public String desc() {
        return "白咖啡";
    }
}
