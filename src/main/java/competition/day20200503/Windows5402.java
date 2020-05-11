package competition.day20200503;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200503
 * @ClassName: Windows5402
 * @Author: markey
 * @Description:
 * @Date: 2020/5/3 10:44
 * @Version: 1.0
 */
public class Windows5402 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minStack = new LinkedList<>();
        Deque<Integer> maxStack = new LinkedList<>();
        int res = 1;
        int start = 0, end = 0;
        while (start <= end && end < nums.length) {
            push(minStack, maxStack, nums[end]);
            while (maxStack.peekFirst() - minStack.peekFirst() > limit) {
                pop(minStack, maxStack, nums[start]);
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

    private void pop(Deque<Integer> minStack, Deque<Integer> maxStack, int n) {
        if (minStack.peekFirst() == n) {
            minStack.pollFirst();
        }
        if (maxStack.peekFirst() == n) {
            maxStack.pollFirst();
        }
    }

    private void push(Deque<Integer> minStack, Deque<Integer> maxStack, int n) {
        while (!minStack.isEmpty() && minStack.peekLast() > n) {
            minStack.pollLast();
        }
        minStack.offerLast(n);
        while (!maxStack.isEmpty() && maxStack.peekLast() < n) {
            maxStack.pollLast();
        }
        maxStack.offerLast(n);
    }
}
