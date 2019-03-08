package com.gx.pattern.decorators;

/**
 * @author gx
 * @ClassName: BlaskCoffee
 * @Description: java类作用描述
 * @date 2019/2/14 15:29
 * @Version: 1.0
 * @since
 */
public class BlaskCoffee implements Coffee {
    @Override
    public String desc() {
        return "黑咖啡";
    }
}
