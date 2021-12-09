package com.markey.leetcode.five;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.five
 * @ClassName: Leetcode506
 * @Author: markey
 * @Description:
 * @Date: 2021/12/2 22:51
 * @Version: 1.0
 */
public class Leetcode506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (o1, o2) -> score[o2] - score[o1]);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if(i == 0) {
                res[index[i]] = "Gold Medal";
                continue;
            }
            if(i == 1) {
                res[index[i]] = "Silver Medal";
                continue;
            }
            if(i == 2) {
                res[index[i]] = "Bronze Medal";
                continue;
            }
            res[index[i]] = String.valueOf(i + 1);
        }
        return res;
    }
}
