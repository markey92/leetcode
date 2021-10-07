package competition.year2021.day20210314;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210314
 * @ClassName: Leetcode5703
 * @Author: markey
 * @Description:
 * @Date: 2021/3/14 10:53
 * @Version: 1.0
 */
public class Leetcode5703 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return get(o2[0], o2[1]) - get(o1[0], o1[1]) > 0 ? 1 : -1;
            }
        });
        for (int i = 0; i < classes.length; i++) {
            priorityQueue.add(classes[i]);
        }
        while (!priorityQueue.isEmpty() && extraStudents > 0){
            int[] clazz = priorityQueue.poll();
            clazz[0] += 1;
            clazz[1] += 1;
            extraStudents -= 1;
            priorityQueue.add(clazz);
        }
        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            res += ((double) classes[i][0])/(classes[i][1]);
            System.out.println(Arrays.toString(classes[i]));
            System.out.println(res);
        }
        return res / classes.length;
    }
    private double get(double x, double y) {
        return (x + 1) / (y + 1) - (x / y);
    }
}
