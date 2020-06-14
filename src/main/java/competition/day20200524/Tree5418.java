package competition.day20200524;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200524
 * @ClassName: Tree5418
 * @Author: markey
 * @Description:5418. 二叉树中的伪回文路径
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 *      在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 *      这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 3：
 *
 * 输入：root = [9]
 * 输出：1
 *
 *
 * 提示：
 *
 * 给定二叉树的节点数目在 1 到 10^5 之间。
 * 节点值在 1 到 9 之间。
 * @Date: 2020/5/24 10:43
 * @Version: 1.0
 */
public class Tree5418 {
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        return pseudoPalindromicPaths(map, root);
    }

    private int pseudoPalindromicPaths (Map<Integer, Integer> map, TreeNode root) {
        int res = 0;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null) {
            res = isPalindromic(map) ? 1 : 0;
        }
        if (root.left != null) {
            res += pseudoPalindromicPaths(map, root.left);
        }
        if (root.right != null) {
            res += pseudoPalindromicPaths(map, root.right);
        }
        map.put(root.val, map.get(root.val) - 1);
        return res;
    }

    private boolean isPalindromic(Map<Integer, Integer> map) {
        int oddCount = 0;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            oddCount += map.get(iterator.next()) % 2;
        }
        return oddCount < 2;
    }
}
