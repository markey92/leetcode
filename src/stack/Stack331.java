package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack331
 * @Author: markey
 * @Description:
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1 21:08
 * @Version: 1.0
 */
public class Stack331 {
    /**
     * Runtime: 14 ms, faster than 6.07% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
     * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
     * 如果需要两个#说明遇到了叶子节点，则将两个叶子节点去掉，并替换这两个叶子节点的父节点为#。跌倒处理直到处理完整个字符串。
     * 如果该树可以退化为一个单节点，说明该字符串符合前序序列化
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        for (String c: preorder.split(",")) {
            stack.push(c);
            while (!stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty() || stack.pop().equals("#")) {
                        return false;
                    }
                    stack.push("#");
                    continue;
                } else {
                    stack.push("#");
                    break;
                }
            }
        }
        System.out.println(stack);
        return stack.isEmpty() || stack.size() == 1 && stack.peek().equals("#");
    }
}
