package com.markey.leetcode.seven;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode743
 * @Author: markey
 * @Description:
 * @Date: 2021/3/7 18:29
 * @Version: 1.0
 */
public class Leetcode743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> paths = new HashMap<>(); // 记录路劲
        for (int i = 0; i < times.length; i++) {
            if (!paths.containsKey(times[i][0])) {
                paths.put(times[i][0], new ArrayList<>());
            }
            paths.get(times[i][0]).add(times[i]);
        }

        // 使用优先队列记录待访问的节点
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        priorityQueue.add(new int[] {k, k, 0});

        Map<Integer, Integer> costs = new HashMap(); // 表示到达每个点的耗时
        while (!priorityQueue.isEmpty()) {
            int[] nextPoint = priorityQueue.poll();
//            System.out.println("next:" + Arrays.toString(nextPoint));
            int end = nextPoint[1];
            int cost = nextPoint[2];
            if (costs.containsKey(end)) {
                continue;
            }
            costs.put(end, cost);
            if (paths.containsKey(end)) {
                // 更新到达下一个节点所需时间
                paths.get(end).forEach(point -> point[2] += cost);
                priorityQueue.addAll(paths.get(end));
            }
//            System.out.println(costs);
        }

        if (costs.size() < k) {
            return -1;
        }

        return costs.values().stream().max(Integer::compareTo).get();
    }
}
