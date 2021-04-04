package CrackingTheCodingInterview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode17_14
 * @Author: markey
 * @Description:
 * @Date: 2020/10/25 23:07
 * @Version: 1.0
 */
public class Leetcode17_14 {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        // 维护一个大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        return priorityQueue.stream().mapToInt(Integer::intValue).toArray();
    }
}
