package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap703
 * @Author: markey
 * @Description:
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/2 10:52
 * @Version: 1.0
 */
public class Heap703 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest2 kthLargest = new KthLargest2(k, arr);
        kthLargest.add(3);// returns 4
        kthLargest.add(5);// returns 5
        kthLargest.add(10);// returns 5
        kthLargest.add(9);// returns 8
        kthLargest.add(4);// returns 8
    }

    /**
     * 执行用时 :74 ms, 在所有 Java 提交中击败了99.19%的用户
     * 内存消耗 :47.8 MB, 在所有 Java 提交中击败了93.52%的用户
     */
    static class KthLargest2 {
        PriorityQueue<Integer> minHeap;
        int k;
        public KthLargest2(int k, int[] nums) {
            minHeap = new PriorityQueue();
            this.k = k;
            for (int x: nums) {
                add(x);
            }
        }

        public int add(int val) {
            if (minHeap.size() < k) {
                minHeap.offer(val);
            } else {
                if (minHeap.peek() < val) {
                    minHeap.poll();
                    minHeap.offer(val);
                }
            }
            System.out.println(minHeap.peek());
            return minHeap.peek();
        }
    }
    /**
     * 循环排序实现，每次重排，效率低
     * 执行用时 :641 ms, 在所有 Java 提交中击败了5.35%的用户
     * 内存消耗 :60.9 MB, 在所有 Java 提交中击败了21.81%的用户
     */
    static class KthLargest {
        List<Integer> nums;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = new ArrayList<>();
            for (int x: nums) {
                this.nums.add(x);
            }
        }

        public int add(int val) {
            nums.add(val);
            nums.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1 - integer;
                }
            });
            System.out.println(nums.get(k-1));
            return nums.get(k-1);
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
}
