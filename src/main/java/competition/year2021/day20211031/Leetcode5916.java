package competition.year2021.day20211031;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211031
 * @ClassName: Leetcode5916
 * @Author: markey
 * @Description:
 * @Date: 2021/10/31 21:23
 * @Version: 1.0
 */
public class Leetcode5916 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(start);
        int[] operations = new int[1001];
        while (!deque.isEmpty()) {
            int x = deque.poll();
            int nextNum;
            for (int num : nums) {
                nextNum = x + num;
                if (nextNum >= 0 && nextNum <= 1000 && operations[nextNum] == 0 && nextNum != x) {
                    operations[nextNum] = operations[x] + 1;
                    deque.addLast(nextNum);
                }
                if (nextNum == goal) {
                    return operations[x] + 1;
                }
                nextNum = x - num;
                if (nextNum >= 0 && nextNum <= 1000 && operations[nextNum] == 0 && nextNum != x) {
                    operations[nextNum] = operations[x] + 1;
                    deque.addLast(nextNum);
                }
                if (nextNum == goal) {
                    return operations[x] + 1;
                }
                nextNum = x ^ num;
                if (nextNum >= 0 && nextNum <= 1000 && operations[nextNum] == 0 && nextNum != x) {
                    operations[nextNum] = operations[x] + 1;
                    deque.addLast(nextNum);
                }
                if (nextNum == goal) {
                    return operations[x] + 1;
                }
            }
        }
        return -1;
    }
}
