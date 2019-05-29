package com.tree;

import java.util.Arrays;
import java.util.List;

/**
 * @author gx
 * @ClassName: App
 * @Description: java类作用描述
 * @date 2019/5/30 0:22
 * @Version: 1.0
 * @since
 */
public class App {
    public static void main(String[] args) {
        List<Node> list=Arrays.asList(
                new Node("2","1","1")
                ,new Node("3","1-1","2")
                ,new Node("4","1-2","2")
                ,new Node("5","1-3","2")
                ,new Node("6","2","1")
                ,new Node("7","2-1","6")
                ,new Node("8","2-2","6")
                ,new Node("9","2-3","10")
                ,new Node("10","2-3-1","9")
                ,new Node("11","2-3-2","9")
                ,new Node("1","总","-1")
        );
        List<Node> tree = TreeUtil.getTree(list);
        int treeNodeCount = TreeUtil.getTreeNodeCount(list);
        List<Node> flatChildren = TreeUtil.getFlatChildren("1",list);
    }
}
