package com.markey.leetcode.two;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.two
 * @ClassName: Leetcode264
 * @Author: markey
 * @Description:
 * @Date: 2021/4/11 9:46
 * @Version: 1.0
 */
public class Leetcode264 {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[1690];
        uglyNums[0] = 1;
        int indexTwo = 0;
        int indexThree = 0;
        int indexFive = 0;
        for (int i = 1; i < n; i++) {
            int min = 0;
            while (min <= uglyNums[i - 1]) {
                int two = uglyNums[indexTwo] * 2;
                int three = uglyNums[indexThree] * 3;
                int five = uglyNums[indexFive] * 5;
                min = Math.min(two, Math.min(three, five));
                if (min == two) {
                    indexTwo++;
                } else if (min == three) {
                    indexThree++;
                } else {
                    indexFive++;
                }
            }
            uglyNums[i] = min;
        }
        System.out.println(Arrays.toString(uglyNums));
        return uglyNums[n - 1];
    }
}
