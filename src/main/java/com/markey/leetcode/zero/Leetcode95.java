package com.markey.leetcode.zero;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode95
 * @Author: markey
 * @Description:
 * @Date: 2020/7/21 22:43
 * @Version: 1.0
 */
public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    temp.right = right;
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
