package competition.year2020.day20200726;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200726
 * @ClassName: Leetcode5474
 * @Author: markey
 * @Description:
 * @Date: 2020/7/26 10:41
 * @Version: 1.0
 */
public class Leetcode5474 {
    int res = 0;
    public int countPairs(TreeNode root, int distance) {
        countPairsList(root, distance);
        return res;
    }
    public List<Integer> countPairsList(TreeNode root, int distance) {
        if (root.left == null && root.right == null) {
            return Collections.singletonList(1);
        }
        List<Integer> left = new ArrayList<>();
        if (root.left != null) {
            left.addAll(countPairsList(root.left, distance));
        }
        List<Integer> right = new ArrayList<>();
        if (root.right != null) {
            right.addAll(countPairsList(root.right, distance));
        }
        res += filter(left, right, distance);
        List<Integer> rootList = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            rootList.add(left.get(i) + 1);
        }
        for (int i = 0; i < right.size(); i++) {
            rootList.add(right.get(i) + 1);
        }
        return rootList;
    }

    private int filter(List<Integer> left, List<Integer> right, int distance) {
        if (left.size() == 0 || right.size() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                if (left.get(i) > distance && right.get(j) > distance) {
                    break;
                }
                if (left.get(i) + right.get(j) <= distance) {
                    res++;
                }
            }
        }
        return res;
    }
}
