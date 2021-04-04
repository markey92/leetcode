package com.markey.leetcode.seven;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode781
 * @Author: markey
 * @Description:
 * @Date: 2021/4/4 9:53
 * @Version: 1.0
 */
public class Leetcode781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Double> count = new HashMap<>();
        for (int x : answers) {
            count.put(x, count.getOrDefault(x, 0.0) + 1);
        }
        int res = 0;
        for (int key : count.keySet()) {
            res += Math.ceil(count.get(key) / (key + 1)) * (key + 1);
        }
        return res;
    }
}
