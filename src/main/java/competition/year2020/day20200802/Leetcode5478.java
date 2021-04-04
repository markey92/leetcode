package competition.year2020.day20200802;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200802
 * @ClassName: Leetcode5478
 * @Author: markey
 * @Description:
 * @Date: 2020/8/2 11:25
 * @Version: 1.0
 */
public class Leetcode5478 {
    Map<Integer, Integer> indexs1 = new HashMap<>();
    Map<Integer, Integer> indexs2 = new HashMap<>();

    public int maxSum(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            indexs1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            indexs2.put(nums2[i], i);
        }
        List<Integer> same = union(nums1, nums2);
        if (same.size() == 0) {
            return (int) (Math.max(sum(nums1, 0, nums1.length), sum(nums2, 0, nums2.length)) % 1000000007);
        }
        System.out.println(same);
        int first = same.get(0);
        long res = Math.max(sum(nums1, 0, indexs1.get(first)), sum(nums2, 0, indexs2.get(first)));
        for (int i = 1; i < same.size(); i++) {
            int start = same.get(i - 1);
            int end = same.get(i);
            res += Math.max(sum(nums1, indexs1.get(start), indexs1.get(end)), sum(nums2, indexs2.get(start), indexs2.get(end)));
        }
        int last = same.get(same.size() - 1);
        res += Math.max(sum(nums1, indexs1.get(last), nums1.length), sum(nums2, indexs2.get(last), nums2.length));
        return (int) (res % 1000000007);
    }

    private long sum(int[] nums, int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
    private List<Integer> union(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        List<Integer> res = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                res.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return res;
    }
}
