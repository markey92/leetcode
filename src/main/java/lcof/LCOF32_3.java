package lcof;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF32_3
 * @Author: markey
 * @Description:面试题32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/20 23:11
 * @Version: 1.0
 */
public class LCOF32_3 {
    // 注意不同方向时，子节点插入列表的顺序
    // 还有其他做法：两个栈 ？ 双端队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean fromLeftToRight = true;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        while (!nodes.isEmpty()) {
            System.out.println(nodes);
            int size = nodes.size();
            List<Integer> res = new ArrayList<>();
            if (fromLeftToRight) {
                System.out.println("size:" + size);
                for (int i = 0; i < size; i++) {
                    System.out.println("i:" + i);
                    TreeNode treeNode = nodes.remove(0);
                    res.add(treeNode.val);
                    if (treeNode.left != null) {
                        nodes.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        nodes.add(treeNode.right);
                    }
                }
            } else {
                System.out.println("size:" + size);
                List<TreeNode> temp = new ArrayList<>();
                for (int i = size - 1; i >= 0 ; i--) {
                    System.out.println("i:" + i);
                    TreeNode treeNode = nodes.remove(i);
                    res.add(treeNode.val);
                    if (treeNode.right != null) {
                        temp.add(0, treeNode.right);
                    }
                    if (treeNode.left != null) {
                        temp.add(0, treeNode.left);
                    }
                }
                nodes = temp;
            }
            fromLeftToRight = !fromLeftToRight;
            result.add(res);
        }
        return result;
    }
}
