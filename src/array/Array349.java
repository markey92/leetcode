package array;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array349
 * @Author: markey
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:00
 * @Version: 1.0
 */
public class Array349 {

    /**
     * Runtime: 40 ms, faster than 7.07% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 37.3 MB, less than 89.19% of Java online submissions for Intersection of Two Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(nums1).forEach(e -> set1.add(e));
        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(nums2).forEach(e -> set2.add(e));
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        for (int i: set1) {
            if (set2.contains(i)) {
                result.add(i);
                count++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Runtime: 36 ms, faster than 9.51% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 36.6 MB, less than 89.19% of Java online submissions for Intersection of Two Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(nums1).forEach(e -> set1.add(e));
        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(nums2).forEach(e -> set2.add(e));
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int count = 0;
        for (int i: set1) {
            result[count] = i;
            count++;
        }
        return result;
    }
}
