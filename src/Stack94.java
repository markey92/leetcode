import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack94 {

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //出栈
            TreeNode treeNode = stack.pop();
            //判空
            if (treeNode == null) {
                continue;
            }
            // 判断叶子节点
            if (treeNode.left == null && treeNode.right == null) {
                list.add(treeNode.val);
                continue;
            }
            //右节点入栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
                treeNode.right = null;
                stack.push(treeNode);
                continue;
            }
            TreeNode left = treeNode.left;
            //中间节点入栈
            treeNode.left = null;
            stack.push(treeNode);
            //左节点入栈
            if (left != null) {
                stack.push(left);
                continue;
            }

        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //出栈
            TreeNode treeNode = stack.pop();
            //判空
            if (treeNode == null) {
                continue;
            }
            //右节点入栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
                treeNode.right = null;
                stack.push(treeNode);
                continue;
            }
            if (treeNode.left != null) {
                TreeNode left = treeNode.left;
                treeNode.left = null;
                //中间节点入栈
                stack.push(treeNode);
                //左节点入栈
                stack.push(left);
                continue;
            }
            list.add(treeNode.val);
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
