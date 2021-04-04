package competition.year2020.day20200126;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.dat20200126
 * @ClassName: Node1334
 * @Author: markey
 * @Description:1334. 阈值距离内邻居最少的城市
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 *
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 *
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2]
 * 城市 1 -> [城市 0, 城市 2, 城市 3]
 * 城市 2 -> [城市 0, 城市 1, 城市 3]
 * 城市 3 -> [城市 1, 城市 2]
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * 输出：0
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * 城市 0 -> [城市 1]
 * 城市 1 -> [城市 0, 城市 4]
 * 城市 2 -> [城市 3, 城市 4]
 * 城市 3 -> [城市 2, 城市 4]
 * 城市 4 -> [城市 1, 城市 2, 城市 3]
 * 城市 0 在阈值距离 4 以内只有 1 个邻居城市。
 *
 * 提示：
 *
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * 所有 (fromi, toi) 都是不同的。
 * @Date: 2020/3/14 11:19
 * @Version: 1.0
 */
public class Node1334 {
    // 用DFS的方法超过时间限制
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        // 第一次遍历，得到所有可以达到的直系邻居
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (edge[2] <= distanceThreshold) {
                map.get(edge[0]).put(edge[1], edge[2]);
                map.get(edge[1]).put(edge[0], edge[2]);
            }
        }
        System.out.println(map);

        // 检查是否有被孤立的城市，返回被孤立的最大id的城市
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 0 && i > res) {
                res = i;
            }
        }
        if (res > -1) {
            return res;
        }

        // 深度遍历找到每个城市能到达的其他城市
        int minCityCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> canArrived = dfs(map, i, distanceThreshold);
            System.out.println(canArrived);
            if (canArrived.size() < minCityCount) {
                minCityCount = canArrived.size();
                res = i;
            } else if(canArrived.size() == minCityCount) {
                res = Math.max(res, i);
            }
        }
        return res;
    }


    public Set<Integer> dfs(Map<Integer, Map<Integer, Integer>> map, int me, int distanceThreshold) {
        Set<Integer> canArrived = new HashSet<>();
        if (distanceThreshold <= 0) {
            return canArrived;
        }

        Map<Integer, Integer> myArrived = map.get(me);
        for (int nextCity: myArrived.keySet()) {
            if (myArrived.get(nextCity) <= distanceThreshold) {
                canArrived.add(nextCity);
                Set<Integer> temp = dfs(map, nextCity, distanceThreshold - myArrived.get(nextCity));
                canArrived.addAll(temp);
            }
        }
        canArrived.add(me);
        return canArrived;
    }
}
