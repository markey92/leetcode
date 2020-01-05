package tree;

import utils.Node;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree599
 * @Author: markey
 * @Description:
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 我们应返回其最大深度，3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:53
 * @Version: 1.0
 */
public class Tree559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int nowDepth = 1;
        int maxDepth = 1;
        for (int i = 0; i < root.children.size(); i++) {
            maxDepth = Math.max(maxDepth, nowDepth + maxDepth(root.children.get(i)));
        }
        return maxDepth;
    }
}
