package com.markey.leetcode.zero;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.zero
 * @ClassName: Leetcode99
 * @Author: markey
 * @Description:
 * @Date: 2021/10/23 18:38
 * @Version: 1.0
 */
public class Leetcode99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        List<Integer> errorNode = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i -1).val) {
                errorNode.add(i);
            }
        }
        System.out.println(errorNode);
        if (errorNode.size() == 1) {
            int errorIndex = errorNode.get(0);
            int temp = list.get(errorIndex).val;
            list.get(errorIndex).val = list.get(errorIndex - 1).val;
            list.get(errorIndex - 1).val = temp;
        }
        if (errorNode.size() == 2) {
            int errorIndex1 = errorNode.get(0) - 1;
            int errorIndex2 = errorNode.get(1);
            int temp = list.get(errorIndex1).val;
            list.get(errorIndex1).val = list.get(errorIndex2).val;
            list.get(errorIndex2).val = temp;
        }
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (node.left != null) {
            inorder(node.left, list);
        }
        list.add(node);
        if (node.right != null) {
            inorder(node.right, list);
        }
    }
}
