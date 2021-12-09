package com.markey.leetcode.three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode372
 * @Author: markey
 * @Description:
 * @Date: 2021/12/5 16:51
 * @Version: 1.0
 */
public class Leetcode372 {
    public int superPow(int a, int[] b) {
        a = a % 1337;
        int x_contribute = a;
        int res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = res * powA(a, b[i]) % 1337;
            x_contribute = powA(x_contribute, new Integer(10));
        }
        List<Integer> list = new ArrayList<>();
        list.remove(new Integer(1));
        return res;
    }

    private int powA(int a, int x) {
        int res = 1;
        while (x > 0) {
            if ((x & 1) == 1) {
                res = (res * x) % 1337;
            }
            a = a * a % 1337;
            x >>= 1;
        }
        System.out.println(res);
        return res;
    }
}
