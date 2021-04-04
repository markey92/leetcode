package high_level.segment_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: high_level.segment_tree
 * @ClassName: Leetcode699
 * @Author: markey
 * @Description:
 * @Date: 2020/11/6 21:42
 * @Version: 1.0
 */
public class Leetcode699 {

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();

        //记下最大值
        int max = 0;
        SegmentTree segmentTree = null;
        for (int[] p : positions) {
            //线段的起点终点
            int start = p[0], end = p[0] + p[1];
            int curHeight = query(segmentTree, start, end) + p[1];
            //当前线程加上后的高度最大值
            segmentTree = insert(segmentTree, start, end, curHeight);

            //记下结果
            max = Math.max(max, curHeight);
            result.add(max);
        }
        return result;
    }

    private int query(SegmentTree root, int start, int end) {
        if (root == null) return 0;
        int maxHeight = 0;
        if (!(end <= root.start || root.end <= start)) {
            // 有交叉
            maxHeight = root.height;
        }
        maxHeight = Math.max(maxHeight, query(root.left, start, end));
        if (end > root.start) {
            maxHeight = Math.max(maxHeight, query(root.right, start, end));
        }
        System.out.println(maxHeight);
        return maxHeight;
    }

    private SegmentTree insert(SegmentTree root, int start, int end, int height) {
        if (root == null) {
            return new SegmentTree(start, end, height);
        }
        if (start <= root.start)
            root.left = insert(root.left, start, end, height);
        else
            root.right = insert(root.right, start, end, height);
        return root; // 返回根节点
    }

    class SegmentTree {
        //线段的起点，终点和高度
        int start, end, height;
        //左右子节点和中间重叠部分
        SegmentTree left, right;

        public SegmentTree(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
            this.left = null;
            this.right = null;
        }
    }
}
