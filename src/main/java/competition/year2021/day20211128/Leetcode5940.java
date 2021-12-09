package competition.year2021.day20211128;

/**
 * @ProjectName: leetcode
 * @Package: competition.year2021.day20211128
 * @ClassName: Leetcode5940
 * @Author: markey
 * @Description:
 * @Date: 2021/11/28 10:44
 * @Version: 1.0
 */
public class Leetcode5940 {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int res = Math.max(minIndex, maxIndex) + 1;
        res = Math.min(res,  nums.length - Math.min(minIndex, maxIndex));
        res = Math.min(res, (nums.length - Math.max(minIndex, maxIndex) + Math.min(minIndex, maxIndex) + 1));
        return res;
    }
}
