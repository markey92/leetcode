package com.markey.leetcode.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.zero
 * @ClassName: Leetcode57
 * @Author: markey
 * @Description:
 * @Date: 2021/10/7 19:31
 * @Version: 1.0
 */
public class Leetcode57 {
    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> all = new ArrayList<>();
        all.add(newInterval);
        for (int[] interval: intervals) {
            all.add(interval);
        }
        all.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval: all) {
            if (res.isEmpty()) {
                res.add(interval);
                continue;
            }
            // 与上一个区间比较
            int[] lastInterval = res.get(res.size() - 1);
            if (lastInterval[1] >= interval[0]) {
                // 有交集，需要合并倒上一个区间
                interval[0] = Math.min(interval[0], lastInterval[0]);
                interval[1] = Math.max(interval[1], lastInterval[1]);
                res.remove(res.size() - 1);
                res.add(interval);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
