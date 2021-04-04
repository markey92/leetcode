package competition.day20210110;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210110
 * @ClassName: Leetcode5650
 * @Author: markey
 * @Description:
 * @Date: 2021/1/10 10:43
 * @Version: 1.0
 */
public class Leetcode5650 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < allowedSwaps.length; i++) {
            unionFind.union(allowedSwaps[i][0], allowedSwaps[i][1]);
        }
        Map<Integer, Map<Integer, Integer>> sourceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            if (!sourceMap.containsKey(root)) {
                sourceMap.put(root, new HashMap<>());
            }
            Map<Integer, Integer> count = sourceMap.get(root);
            int num = source[i];
            System.out.println(i + " " + root + " " + num);
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }
        System.out.println(sourceMap);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            int num = target[i];
            Map<Integer, Integer> count = sourceMap.get(root);
            System.out.println(i + " " + root + " " + num);
            if (count.getOrDefault(num, 0) > 0) {
                count.put(num, count.get(num) - 1);
            } else {
                res++;
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parent[parentX] = parentY;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
}
