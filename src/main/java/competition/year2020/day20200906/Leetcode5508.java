package competition.year2020.day20200906;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200906
 * @ClassName: Leetcode5508
 * @Author: markey
 * @Description:
 * @Date: 2020/9/6 10:35
 * @Version: 1.0
 */
public class Leetcode5508 {
    public int numTriplets(int[] nums1, int[] nums2) {
        int res = 0;
        Map<Long, Integer> nums1Double = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Double.put( ((long)nums1[i] * nums1[i]), nums1Double.getOrDefault((long)nums1[i] * nums1[i], 0) + 1);
        }
        System.out.println(nums1Double);
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                System.out.println((long)nums2[i] * nums2[j]);
                res += nums1Double.getOrDefault((long)nums2[i] * nums2[j], 0);
            }
        }

        Map<Long, Integer> nums2Double = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2Double.put((long) ((long)nums2[i] * nums2[i]), nums2Double.getOrDefault((long)nums2[i] * nums2[i], 0) + 1);
        }
        System.out.println(nums2Double);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                System.out.println((long)nums1[i] * nums1[j]);
                res += nums2Double.getOrDefault((long)nums1[i] * nums1[j], 0);
            }
        }
        return res;
    }
}
