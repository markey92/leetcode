package competition.day20211010;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211010
 * @ClassName: Leetcode5894
 * @Author: markey
 * @Description:
 * @Date: 2021/10/10 10:30
 * @Version: 1.0
 */
public class Leetcode5894 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            count.put(nums1[i], count.getOrDefault(nums1[i], 0) | 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            count.put(nums2[i], count.getOrDefault(nums2[i], 0) | 2);
        }
        for (int i = 0; i < nums3.length; i++) {
            count.put(nums3[i], count.getOrDefault(nums3[i], 0) | 4);
        }
        System.out.println(count);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 7 || entry.getValue() == 3 || entry.getValue() == 5 || entry.getValue() == 6) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
