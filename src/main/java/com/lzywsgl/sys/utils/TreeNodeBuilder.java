package com.lzywsgl.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @ClassName TreeNodeBuilder
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/2 21:33
 * @Version 1.0
 **/
public class TreeNodeBuilder {
    /**
     * 把简单的集合转成有层级关系的集合
     */
    public static List<TreeNode> builder(List<TreeNode> nodes, Integer topPid) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode n1 : nodes) {
            if (n1.getPid() == topPid) {
                treeNodes.add(n1);
            }
            for (TreeNode n2 : nodes) {
                if (n2.getPid() == n1.getPid()) {
                    n1.getChildren().add(n2);
                }
            }
        }
        return treeNodes;
    }
}
