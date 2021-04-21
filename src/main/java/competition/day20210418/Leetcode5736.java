package competition.day20210418;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210418
 * @ClassName: Leetcode5736
 * @Author: markey
 * @Description:
 * @Date: 2021/4/18 10:35
 * @Version: 1.0
 */
public class Leetcode5736 {
    public static void main(String[] args) {
//        int[][] tasks = {{1,2}, {2,4}, {3,2}, {4,1}};
        int[][] tasks = {{7,10}, {7,12}, {7,5}, {7,4}, {7,2}};
        System.out.println(Arrays.toString(getOrder(tasks)));
    }
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sourceTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sourceTasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(sourceTasks, Comparator.comparingInt(o -> o[0]));

        int[] res = new int[n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[2] - o2[2]);
        int taskId = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            while (taskId < n && sourceTasks[taskId][0] <= time) {
                priorityQueue.add(sourceTasks[taskId]);
                taskId++;
            }
            if (priorityQueue.isEmpty()) {
                time = sourceTasks[i][0];
                while (taskId < n && sourceTasks[taskId][0] <= time) {
                    priorityQueue.add(sourceTasks[taskId]);
                    taskId++;
                }
            }
            int[] exec = priorityQueue.poll();
            res[i] = exec[2];
            time += exec[1];
        }
        return res;
    }
}
