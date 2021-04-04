package competition.year2020.day20200301;

import utils.ListNode;
import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200301
 * @ClassName: Tree5346
 * @Author: markey
 * @Description:
 * @Date: 2020/3/1 10:46
 * @Version: 1.0
 */
public class Tree5346 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            return isPath(head.next, root.left) || isPath(head.next, root.right) || isSubPath(head, root.left) || isSubPath(head, root.right);
        } else {
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }
    public boolean isPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            return isPath(head.next, root.left) || isPath(head.next, root.right);
        } else {
            return false;
        }
    }
}
