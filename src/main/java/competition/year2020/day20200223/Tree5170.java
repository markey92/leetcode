package competition.year2020.day20200223;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200223
 * @ClassName: Tree5170
 * @Author: markey
 * @Description:5170. 验证二叉树
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * 示例 1：
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 * 示例 2：
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * 输出：false
 * 示例 3：
 * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * 输出：false
 * 示例 4：
 * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * 输出：false
 * 提示：
 * 1 <= n <= 10^4
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 * @Date: 2020/2/23 10:43
 * @Version: 1.0
 */
public class Tree5170 {

    public static void main(String[] args) {
        int n = 4; int[]leftChild = {1,-1,3,-1}, rightChild = {2,-1,-1,-1};
        System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
        for (int i = 0; i < n; i++) {
            System.out.println("left " + leftChild[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println("right " + rightChild[i]);
        }
    }

    /**
     * 注意判断回环和不能全部节点形成一棵树的情况
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        boolean res = validateTree(0, leftChild, rightChild, set);
        // 是否使用所有节点
        if (set.size() < n) {
            res = false;
        }
        return res;
    }

    public static boolean validateTree(int node, int[] leftChild, int[] rightChild, Set set) {
        // 回环情况
        if (set.contains(node)) {
            System.out.println("回环");
            return false;
        }
        set.add(node);
        boolean res = true;
        if (leftChild[node] != -1) {
            int leftNode = leftChild[node];
            res = res && validateTree(leftNode, leftChild, rightChild, set);
        }
        if (res && rightChild[node] != -1) {
            int rightNode = rightChild[node];
            res = res && validateTree(rightNode, leftChild, rightChild, set);
        }
        return res;
    }
}
