package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode9
 * @Author: markey
 * @Description:
 * @Date: 2020/7/10 21:43
 * @Version: 1.0
 */
public class Leetcode9 {
    public boolean isPalindrome(int x) {
        int y = reversal(x);
        return x >= 0 && y == x;

    }
    private int reversal(int input){
        int result = 0;
        while(input != 0){
            result = result*10 + input%10;
            input /= 10;
        }
        return result;
    }
}
