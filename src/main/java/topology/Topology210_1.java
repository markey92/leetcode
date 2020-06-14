package topology;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: topology
 * @ClassName: Topology210_1
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 17:29
 * @Version: 1.0
 */
public class Topology210_1 {
    // BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 统计节点的入度
        for(int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 将入度为0的点入队
        for(int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            res[idx++] = temp;
            // 修改节点入度
            for(int[] edge : prerequisites) {
                if (edge[1] == temp) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        // 出现环了(res中没包括所有点, idx没走完)
        if(idx != numCourses) {
            return new int[] {};
        }
        return res;
    }
}
