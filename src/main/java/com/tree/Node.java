package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gx
 * @ClassName: Node
 * @Description: java类作用描述
 * @date 2019/5/30 0:20
 * @Version: 1.0
 * @since
 */
public class Node {
    private String id;
    private String name;
    private String parentId;
    private List<Node> children = new ArrayList<Node>();

    public Node() {

    }

    public Node(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
