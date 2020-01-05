package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array350
 * @Author: markey
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:02
 * @Version: 1.0
 */
public class Array350 {

    /**
     * 执行用时 :50 ms, 在所有 java 提交中击败了6.55%的用户
     * 内存消耗 :36.4 MB, 在所有 java 提交中击败了57.60%的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i: nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i: nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int key: map1.keySet()) {
            for (int i = 0; i < Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0)) ; i++) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
