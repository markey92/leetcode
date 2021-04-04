package competition.year2020.day20201220;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201220
 * @ClassName: Leetcode5631
 * @Author: markey
 * @Description:
 * @Date: 2020/12/20 10:55
 * @Version: 1.0
 */
public class Leetcode5631 {
    public int maxResult(int[] nums, int k) {
        int[] sum = new  int[nums.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> sum[o2] - sum[o1]);
        sum[0] = nums[0];
        priorityQueue.add(0);
        for (int i = 1; i < nums.length; i++) {
            while (priorityQueue.peek() < (i - k)) {
                // 删除超出区间（当前位置的前k个位置）的位置
                priorityQueue.poll();
            }
            System.out.println(priorityQueue);
            sum[i] = nums[i] + sum[priorityQueue.peek()];
            priorityQueue.add(i);
        }
        System.out.println(Arrays.toString(sum));
        return sum[nums.length - 1];
    }
    public int maxResult1(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        res[0] = nums[0];
        stack.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] + stack.peek();
            if (res[i] >= stack.peek()) {
                stack.add(res[i]);
            }
        }
        return 0;
    }
}
