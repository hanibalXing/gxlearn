package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gx
 * @ClassName: TreeUtil
 * @Description: java类作用描述
 * @date 2019/5/30 0:20
 * @Version: 1.0
 * @since
 */
public class TreeUtil {
    // 入口方法
    public static List<Node> getTree(List<Node> nodeList) {
        List<Node> list = new ArrayList<Node>();
        // 遍历节点列表
        for (Node node : nodeList) {
            if (node.getParentId().equals("-1")) {
                // parentID为-1（根节点）作为入口
                node.setChildren(getChildrenNode(node.getId(), nodeList));
                list.add(node);
            }
        }
        return list;
    }

    public static int getTreeNodeCount(List<Node> nodeList) {
        int i=0;
        // 遍历节点列表
        for (Node node : nodeList) {
            i++;
            if (node.getParentId().equals("-1")) {
                // parentID为-1（根节点）作为入口
                node.setChildren(getChildrenNode(node.getId(), nodeList));

            }
        }
        return i;
    }

    private static List<Node> getChildrenNode(String id, List<Node> nodeList) {
        List<Node> list = new ArrayList<Node>();
        for (Node node : nodeList) {
            if (node.getParentId().equals(id)) {
                // 递归获取子节点
                node.setChildren(getChildrenNode(node.getId(), nodeList));
                list.add(node);
            }
        }
        return list;
    }

    // 获取某个节点下的所有子节点
    public static List<Node> getFlatChildren(String id, List<Node> nodeList) {
        List<Node> list = new ArrayList<Node>();
        nodeList.forEach(node -> {
            if(node.getParentId().equals(id)) {
                list.add(node);
                list.addAll(getFlatChildren(node.getId(),node.getChildren()));
            }
        });

        return list;
    }

}
