package competition.year2020.day20200906;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200906
 * @ClassName: Leetcode5510
 * @Author: markey
 * @Description: 部分用例过
 * @Date: 2020/9/6 11:08
 * @Version: 1.0
 */
public class Leetcode5510 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int max1 = maxNum(n, 1, edges);
        if (max1 == -1) {
            return -1;
        }
        int max2 = maxNum(n, 2, edges);
        if (max2 == -1) {
            return -1;
        }
        return max1 +max2;
    }
    public int maxNum(int n, int type, int[][] edges) {
        int[] parent = new int[n + 1];
        int noNeed = 0;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (edge[0] == 3 || edge[0] == type) {
                int from = edge[1];
                int to = edge[2];
                if (parent[from] > 0 && parent[to] > 0) {
//                    System.out.println("from:" + from + " to:" + to);
                    noNeed++;
                } else {
                    int min = Math.min(from, to);
                    changeParent(parent, from, min);
                    changeParent(parent, to, min);
                }

            }
        }
//        System.out.println("type:" + type + " noNeed:" + noNeed);
        for (int i = 1; i <= n; i++) {
            if (parent[i] == 0) {
                return -1;
            }
        }
        System.out.println(Arrays.toString(parent));
        return noNeed;
    }

    private void changeParent(int[] parent, int me, int newParent) {
        int oldParent = parent[me];
        if (oldParent == 0) {
            parent[me] = newParent;
            changeParent(parent, newParent, me);
        } else {
            if (newParent < oldParent) {
                parent[me] = newParent;
                changeParent(parent, oldParent, newParent);
            }
            if (newParent > oldParent) {
                changeParent(parent, newParent, oldParent);
            }
        }
    }

}
