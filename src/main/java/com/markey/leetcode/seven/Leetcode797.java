package com.markey.leetcode.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode797
 * @Author: markey
 * @Description:
 * @Date: 2021/3/7 22:14
 * @Version: 1.0
 */
public class Leetcode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> initRoute = new ArrayList<>();
        initRoute.add(0);
        return dfs(initRoute, n - 1, graph);
    }

    public List<List<Integer>> dfs(List<Integer> route, int target, int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int preNode = route.get(route.size() - 1);
        if (preNode == target) {
            res.add(route);
            return res;
        }
        int[] nextNodes = graph[preNode];
        for (Integer next : nextNodes) {
            if (route.contains(next)) {
                // 避免回环
                continue;
            }
            List<Integer> nextRoute = new ArrayList<>(route);
            nextRoute.add(next);
            res.addAll(dfs(nextRoute, target, graph));
        }
        return res;
    }
}
