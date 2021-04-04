package high_level.binary_indexed_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: high_level.binary_indexed_tree
 * @ClassName: Leetcode493
 * @Author: markey
 * @Description:
 * @Date: 2020/11/6 20:41
 * @Version: 1.0
 */
public class Leetcode493 {
    public int reversePairs(int[] nums) {
        // 状态压缩
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add((long) nums[i]);
            treeSet.add((long) nums[i] * 2);
        }
        Map<Long, Integer> map = new HashMap<>();
        int index = 1;
        while (!treeSet.isEmpty()) {
            map.put(treeSet.pollFirst(), index++);
        }

        // 树状数组
        int n = nums.length;
        int[] C = new int[map.size()];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += query(C, map.get((long) nums[i]) - 1);
            update(C, map.get((long) nums[i] * 2));
        }
        return res;
    }

    private int lowbit(int n) {
        return n & (-n);
    }

    private void update(int[] C, int num) {
        while (num < C.length) {
            C[num]++;
            num += lowbit(num);
        }
    }

    private int query(int[] C, int num) {
        int res = 0;
        while (num > 0) {
            res += C[num];
            num -= lowbit(num);
        }
        return res;
    }
}
