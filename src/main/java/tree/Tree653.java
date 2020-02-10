package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree653
 * @Author: markey
 * @Description:
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/9 10:09
 * @Version: 1.0
 */
public class Tree653 {
    //双指针 先将树转成排序列表，然后前后指针来找出合适的节点对

    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了9.70%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了54.77%的用户
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = covertToList(root);
        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (list.get(start) + list.get(end) < k) {
                start++;
                continue;
            }
            if (list.get(start) + list.get(end) > k) {
                end--;
                continue;
            }
            return true;
        }
        return false;
    }

    private List<Integer> covertToList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(covertToList(root.left));
        res.add(root.val);
        res.addAll(covertToList(root.right));
        return res;

    }

    //遍历法

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了28.18%的用户
     * 内存消耗 :43.3 MB, 在所有 Java 提交中击败了29.73%的用户
     */
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
