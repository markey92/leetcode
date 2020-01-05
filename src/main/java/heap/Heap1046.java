package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: heap
 * @Author: markey
 * @Description:
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *  [2,7,4,1,8,1] 返回1
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/2 10:03
 * @Version: 1.0
 */
public class Heap1046 {

    public static void main(String[] args) {
        int[] input = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight3(input));
    }

    /**
     * java大顶堆
     * 执行用时 :43 ms, 在所有 Java 提交中击败了10.83%的用户
     * 内存消耗 :34.4 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int lastStoneWeight3(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int x: stones) {
            pq.offer(x);
        }
        while (pq.size() > 1) {
            int remaining = pq.poll() - pq.poll();
            if (remaining != 0) {
                pq.offer(remaining);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
    /**
     * 循环排序
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int lastStoneWeight2(int[] stones) {
        Arrays.sort(stones);
        while (stones.length > 1 && stones[stones.length - 2] > 0) {
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length-1];
    }
    /**
     * 双栈实现最大堆
     * 执行用时 : 7 ms, 在所有 Java 提交中击败了15.14%的用户
     * 内存消耗 :34 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int lastStoneWeight(int[] stones) {
        Stack<Integer> max = new Stack();
        Stack<Integer> temp = new Stack<>();
        for (int x: stones) {
            while (!max.isEmpty() && max.peek() > x) {
                temp.push(max.pop());
            }
            max.push(x);
            while (!temp.isEmpty()) {
                max.push(temp.pop());
            }
        }
        while (max.size() > 1) {
            int remaining = max.pop() - max.pop();
            if (remaining != 0) {
                while (!max.isEmpty() && max.peek() > remaining) {
                    temp.push(max.pop());
                }
                max.push(remaining);
                while (!temp.isEmpty()) {
                    max.push(temp.pop());
                }
            }
        }
        return max.isEmpty() ? 0 : max.pop();
    }
}
