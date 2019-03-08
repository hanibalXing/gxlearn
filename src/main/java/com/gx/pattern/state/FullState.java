package com.gx.pattern.state;

/**
 * @author gx
 * @ClassName: FullState
 * @Description: java类作用描述
 * @date 2019/2/3 15:41
 * @Version: 1.0
 * @since
 */
public class FullState implements BoxState {
    @Override
    public String state() {
        return "the box is full,can't put book";
    }
}
