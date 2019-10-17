package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap373
 * @Author: markey
 * @Description:
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/7 22:29
 * @Version: 1.0
 */
public class Heap373 {

    public static void main(String[] args) {

    }

    /**
     * 使用优先队列模拟小顶堆，自定义大小比较方法
     * 执行用时 :58 ms, 在所有 Java 提交中击败了57.83%的用户
     * 内存消耗 :51.1 MB, 在所有 Java 提交中击败了37.33%的用户
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((i1, i2) -> i1[0] + i1[1] - i2[0] - i2[1]);
        for (int x: nums1) {
            for (int y: nums2) {
                minHeap.offer(new int[] {x, y});
            }
        }
        List result = new ArrayList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
