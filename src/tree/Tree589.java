package tree;

import utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree589
 * @Author: markey
 * @Description:
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/11/4 22:52
 * @Version: 1.0
 */
public class Tree589 {
    /**
     * Runtime: 4 ms, faster than 18.67% of Java online submissions for N-ary Tree Preorder Traversal.
     * Memory Usage: 49.3 MB, less than 12.20% of Java online submissions for N-ary Tree Preorder Traversal.
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node == null) {
                continue;
            }
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
