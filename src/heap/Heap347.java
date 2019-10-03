package heap;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap347
 * @Author: markey
 * @Description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/3 10:44
 * @Version: 1.0
 */
public class Heap347 {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }

    /**
     * 优先队列解法
     * 执行用时 :58 ms, 在所有 Java 提交中击败了41.63%的用户
     * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了97.11%的用户
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int c: nums) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(
                (i1, i2) -> map.get(i2)- map.get(i1));
        for (int c: map.keySet()) {
            priorityQueue.add(c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll());
        }
        return result;
    }
}
