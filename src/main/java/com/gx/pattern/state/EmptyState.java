package com.gx.pattern.state;

/**
 * @author gx
 * @ClassName: EmptyState
 * @Description: java类作用描述
 * @date 2019/2/3 15:41
 * @Version: 1.0
 * @since
 */
public class EmptyState implements BoxState {
    @Override
    public String state() {
        return "the box can put book";
    }
}
