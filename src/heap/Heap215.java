package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap215
 * @Author: markey
 * @Description:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/3 10:15
 * @Version: 1.0
 */
public class Heap215 {

    public static void main(String[] args) {
        int result = findKthLargest2(new int[] {3,2,1,5,6,4}, 2);
        System.out.println(result);
    }

    /**
     * 排序
     * 执行用时 :4 ms, 在所有 Java 提交中击败了91.84%的用户
     * 内存消耗 :38.4 MB, 在所有 Java 提交中击败了89.07%的用户
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    /**
     * 优先队列
     * 执行用时 :6 ms, 在所有 Java 提交中击败了79.91%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了94.58%的用户
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int x: nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(x);
            } else {
                if (priorityQueue.peek() < x) {
                    priorityQueue.poll();
                    priorityQueue.add(x);
                }
            }
        }
        return priorityQueue.poll();
    }
}
