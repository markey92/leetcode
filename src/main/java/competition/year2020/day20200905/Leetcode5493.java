package competition.year2020.day20200905;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200905
 * @ClassName: Leetcode5493
 * @Author: markey
 * @Description:
 * @Date: 2020/9/5 22:50
 * @Version: 1.0
 */
public class Leetcode5493 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        System.out.println(n);
        if (n == 1) {
            return 0;
        }
        Stack<Integer> maxStack = new Stack<>();
        maxStack.add(0);
        int temp = 1;
        while (temp < n && arr[temp] > arr[temp - 1]) {
            maxStack.add(temp);
            temp++;
        }
        if (maxStack.size() == n) {
            return 0;
        }
        Stack<Integer> minStack = new Stack<>();
        minStack.add(n - 1);
        temp = n - 2;
        while (temp >= 0 && arr[temp] < arr[temp + 1]) {
            minStack.add(temp);
            temp--;
        }
        System.out.println(maxStack);
        System.out.println(minStack);
        int max = arr[maxStack.peek()];
        int min = arr[minStack.peek()];
        System.out.println("max" + max);
        System.out.println("min" + min);
        int res = minStack.peek() - maxStack.peek() - 1;
        int countX = 0;
        while (!maxStack.isEmpty() && arr[maxStack.peek()] > min) {
            countX++;
            maxStack.pop();
        }
        System.out.println(countX);
        int countY = 0;
        while (!minStack.isEmpty() && arr[minStack.peek()] < max) {
            countY++;
            minStack.pop();
        }
        System.out.println(countY);
        return res + Math.min(countX, countY);
    }
}
