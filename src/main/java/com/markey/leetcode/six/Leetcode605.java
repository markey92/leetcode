package com.markey.leetcode.six;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.six
 * @ClassName: Leetcode605
 * @Author: markey
 * @Description:
 * @Date: 2021/1/1 18:14
 * @Version: 1.0
 */
public class Leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                if (i != 0 && flowerbed[i - 1] == 1) {
                    continue;
                }
                if (i != flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                    continue;
                }
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
