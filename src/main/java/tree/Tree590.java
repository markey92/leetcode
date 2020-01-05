package tree;

import utils.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree590
 * @Author: markey
 * @Description:
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/11/4 22:43
 * @Version: 1.0
 */
public class Tree590 {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for N-ary Tree Postorder Traversal.
     * Memory Usage: 44.4 MB, less than 97.30% of Java online submissions for N-ary Tree Postorder Traversal.
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(Node node, List<Integer> nodelist) {
        if (node == null) {
            return;
        }
        for (Node child: node.children) {
            helper(child, nodelist);
        }
        nodelist.add(node.val);
    }
}
