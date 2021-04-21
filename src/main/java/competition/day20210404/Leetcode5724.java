package competition.day20210404;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210404
 * @ClassName: Leetcode5724
 * @Author: markey
 * @Description:
 * @Date: 2021/4/4 10:40
 * @Version: 1.0
 */
public class Leetcode5724 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            treeSet.add(nums1[i]);
        }
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            Integer ceiling = treeSet.ceiling(nums2[i]);
            Integer floor = treeSet.floor(nums2[i]);
            if (ceiling == null) {
                ceiling = nums1[i];
            }
            if (floor == null) {
                floor = nums1[i];
            }
            int x = Math.abs(ceiling - nums2[i]);
            int y = Math.abs(floor - nums2[i]);
            diff[i] = Math.min(x, y);
        }
        System.out.println(Arrays.toString(diff));
        long res = 0;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diffThis = Math.abs(nums1[i] - nums2[i]);
            res = (res + diffThis) % 1_000_000_007;
            maxDiff = Math.max(maxDiff, diffThis - diff[i]);
            System.out.println(maxDiff);
        }
        return (int) (res - maxDiff) % 1_000_000_007;
    }
}
