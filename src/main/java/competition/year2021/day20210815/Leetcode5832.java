package competition.year2021.day20210815;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210815
 * @ClassName: Leetcode5832
 * @Author: markey
 * @Description:
 * @Date: 2021/8/15 10:33
 * @Version: 1.0
 */
public class Leetcode5832 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[start++];
            } else {
                res[i] = nums[end--];
            }
        }
        return res;
    }
}
