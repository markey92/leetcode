package competition.year2020.day20200614;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200614
 * @ClassName: Tree5188
 * @Author: markey
 * @Description:
 * @Date: 2020/6/14 11:11
 * @Version: 1.0
 */
public class Tree5188 {
    class TreeAncestor {
        Map<Integer, Map<Integer, Integer>> map;
        Map<Integer, Integer> min;
        int n;
        public TreeAncestor(int n, int[] parent) {
            this.n = n;
            this.map = new HashMap<>();
            this.min = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(1,parent[i]);
                this.min.put(i, 1);
                this.map.put(i, temp);
            }
        }

        public int getKthAncestor(int node, int k) {
            if (k >= n) {
                return -1;
            }
            Map<Integer, Integer> parents = this.map.get(node);
            if (parents.containsKey(k)) {
                return parents.get(k);
            }
            //找到比k小的最大的key
            int max = min.get(node);
            if (k < max) {
                max = k - 1;
            }
            int lastParent = getKthAncestor(node, max);
            int parent = -1;
            if (lastParent != -1) {
                parent = getKthAncestor(lastParent, k - max);
            }
            parents.put(k, parent);
            if (k > min.get(node)) {
                min.put(node, k);
            }
//            System.out.println(this.map);
            return parent;
        }
    }
}
