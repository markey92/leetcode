package high_level.binary_indexed_tree;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: high_level.binary_indexed_tree
 * @ClassName: Leetcode327
 * @Author: markey
 * @Description:
 * @Date: 2020/11/7 21:02
 * @Version: 1.0
 */
public class Leetcode327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // 求前缀和
        long[] preSum = new long[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        System.out.println(Arrays.toString(preSum));

        // 状态压缩
        Set<Long> set = new TreeSet<>();
        for (long x : preSum) {
            set.add(x);
            set.add(x - lower);
            set.add(x - upper);
        }
        Map<Long, Integer> index = new HashMap<>();
        int idx = 0;
        for (long x : set) {
            index.put(x, idx++);
        }
        System.out.println(index);

        // 遍历每个前缀和
        int res = 0;
        int[] C = new int[set.size() + 1];
        for (int i = 0; i < preSum.length; i++) {
            int left = index.get(preSum[i] - upper);
            int right = index.get(preSum[i] - lower);
            res += query(C, right + 1) - query(C, left);
            System.out.println(Arrays.toString(C));
            System.out.println(left + ":" + right + ":" + res);
            update(C, index.get(preSum[i]) + 1);
        }
        return res;
    }

    private int query(int[] C, int num) {
        int res = 0;
        while (num > 0) {
            res += C[num];
            num -= lowBit(num);
        }
        return res;
    }

    private void update(int[] C, int num) {
        while (num < C.length) {
            C[num]++;
            num += lowBit(num);
        }
    }
    private int lowBit(int n) {
        return n & (-n);
    }
}
