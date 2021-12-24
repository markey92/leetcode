package com.markey.leetcode.one;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode1705
 * @Author: markey
 * @Description:
 * @Date: 2021/12/24 21:33
 * @Version: 1.0
 */
public class Leetcode1705 {
    public int eatenApples(int[] apples, int[] days) {
        TreeMap<Integer, Integer> applesMap = new TreeMap<>(); // key是过期时间，value是个数
        int n = apples.length;
        int res = 0;
        int i;
        for (i = 0; i < n; i++) {
            int expriedTime = i + days[i];
            if (apples[i] > 0) {
                applesMap.put(expriedTime, apples[i] + applesMap.getOrDefault(expriedTime, 0));
            }
            if (!applesMap.isEmpty()) {
                Map.Entry<Integer, Integer> entry = applesMap.pollFirstEntry();
                if (entry.getKey() > i + 1 && entry.getValue() > 1) {
                    applesMap.put(entry.getKey(), entry.getValue() - 1);
                }
                res++;
            }
            System.out.println(applesMap);
        }
        while (!applesMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = applesMap.pollFirstEntry();
            if (entry.getKey() > i + 1 && entry.getValue() > 1) {
                applesMap.put(entry.getKey(), entry.getValue() - 1);
            }
            res++;
            i++;
            System.out.println(applesMap);
        }
        return res;
    }
}
