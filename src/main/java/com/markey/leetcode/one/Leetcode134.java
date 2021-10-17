package com.markey.leetcode.one;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode134
 * @Author: markey
 * @Description:
 * @Date: 2021/10/8 21:16
 * @Version: 1.0
 */
public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 找到最有可能走一圈的起始站
        int left = 0;
        int start = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] - cost[i] > left + gas[i] - cost[i]) {
                // 如果直接从当前节点开始，可以剩余的油量，比从上一个起点跑到当前节点要多
                start = i;
                left = gas[i] - cost[i];
            } else {
                left += gas[i] - cost[i];
            }
        }
        // 判断能否走完
        System.out.println(start);
        left = 0;
        for (int i = 0; i < n; i++) {
            left += gas[(i + start) % n] - cost[(i + start) % n];
            if (left < 0) {
                return -1;
            }
        }
        return start;
    }
}
