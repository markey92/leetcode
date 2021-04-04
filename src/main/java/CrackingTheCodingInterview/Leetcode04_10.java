package CrackingTheCodingInterview;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_10
 * @Author: markey
 * @Description:
 * @Date: 2020/9/26 10:50
 * @Version: 1.0
 */
public class Leetcode04_10 {
    /**
     * 序列化后比较字符串，
     * 中序、前序、后续遍历均可
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        String t1String = toString(t1);
        String t2String = toString(t2);
        System.out.println(t1String);
        System.out.println(t2String);
        return t1String.contains(t2String);
    }

    private String toString(TreeNode node) {
        if (node == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(toString(node.left));
        stringBuilder.append(node.val);
        stringBuilder.append(toString(node.right));
        return stringBuilder.toString();
    }
}
