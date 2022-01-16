package competition.year2021.day20211024;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211024
 * @ClassName: Leetcode5908
 * @Author: markey
 * @Description:
 * @Date: 2021/10/24 12:18
 * @Version: 1.0
 */
public class Leetcode5908 {
    public static void main(String[] args) {
        Leetcode5908 leetcode5908 = new Leetcode5908();
        leetcode5908.countHighestScoreNodes(new int[] {-1,2,0,2,0});
    }
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        TreeNode[] treeNodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            treeNodes[i] = new TreeNode();
        }
        for (int i = 1; i < n; i++) {
            // 0是根，没有父节点
            treeNodes[parents[i]].addSubNode(treeNodes[i]);
        }
        int count = 1;
        long max = 0;
        long temp;
        for (int i = 0; i < n; i++) {
            temp = 1;
            for (TreeNode subNode : treeNodes[i].subNode) {
                temp *= subNode.getVal();
            }
            if (i != 0) {
                temp *= n - treeNodes[i].getVal();
            }
            if (temp > max) {
                max = temp;
                count = 1;
            } else if (temp == max) {
                count++;
            }
        }
        return count;
    }

    class TreeNode {
        int val;
        List<TreeNode> subNode;

        public TreeNode() {
            this.subNode = new ArrayList<>();
        }

        public void addSubNode(TreeNode node) {
            this.subNode.add(node);
        }

        public int getVal() {
            if (this.val == 0) {
                int res = 1;
                for (TreeNode node : subNode) {
                    res += node.getVal();
                }
                this.val = res;
            }
            return this.val;
        }
    }
}
