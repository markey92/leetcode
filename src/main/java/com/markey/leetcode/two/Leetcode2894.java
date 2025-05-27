package com.markey.leetcode.two;

public class Leetcode2894 {
    public int differenceOfSums(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (n % m == 0) {
                res -= i;
                System.out.printf("-%d", i);
            } else {
                res +=i;
                System.out.printf("+%d", i);
            }
        }
        return res;
    }
}
