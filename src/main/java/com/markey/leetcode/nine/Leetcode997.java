package com.markey.leetcode.nine;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.nine
 * @ClassName: Leetcode997
 * @Author: markey
 * @Description:
 * @Date: 2021/12/19 20:24
 * @Version: 1.0
 */
public class Leetcode997 {
    public int findJudge(int n, int[][] trust) {
        int[] beTrustNums = new int[n + 1];
        Set<Integer> trustOther = new HashSet<>();
        for (int i = 0; i < trust.length; i++) {
            trustOther.add(trust[i][0]);
            beTrustNums[trust[i][1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (beTrustNums[i] == n - 1 && !trustOther.contains(i)) {
                return i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        return -1;
    }
}
