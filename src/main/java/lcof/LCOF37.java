package lcof;

import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF37
 * @Author: markey
 * @Description:面试题37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/2 0:17
 * @Version: 1.0
 */
public class LCOF37 {
    // 层次序列化二叉树，因为层次序列化不能确定一颗唯一的二叉树，在每个叶子节点的下一层次需要增加两个左右节点null，可唯一确定二叉树
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add(null);
            } else {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        String s =res.stream().map(i -> i == null ? null : String.valueOf(i.intValue())) //必须将普通数组 boxed才能 在 map 里面 toString
                .collect(Collectors.joining(","));
        System.out.println(res);
        return '[' + s + ']';
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] list = data.substring(1, data.length() - 1).split(",");
        TreeNode root = list[0].equals("null") ? null : new TreeNode(Integer.valueOf(list[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (index < list.length) {
            TreeNode left = list[index].equals("null") ? null : new TreeNode(Integer.valueOf(list[index]));
            if (left != null) {
                queue.add(left);
            }
            index ++;
            TreeNode right = list[index].equals("null") ? null : new TreeNode(Integer.valueOf(list[index]));
            if (right != null) {
                queue.add(right);
            }
            index ++;

            TreeNode node = queue.poll();
            node.left = left;
            node.right = right;
        }
        return root;
    }
}
