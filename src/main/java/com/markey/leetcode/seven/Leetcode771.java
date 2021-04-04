package com.markey.leetcode.seven;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode744
 * @Author: markey
 * @Description:
 * @Date: 2020/10/2 10:20
 * @Version: 1.0
 */
public class Leetcode771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) > -1) {
                count++;
            }
        }
        return count;
    }
}
