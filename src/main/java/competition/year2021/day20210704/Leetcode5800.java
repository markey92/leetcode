package competition.year2021.day20210704;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210704
 * @ClassName: Leetcode5800
 * @Author: markey
 * @Description:
 * @Date: 2021/7/4 10:30
 * @Version: 1.0
 */
public class Leetcode5800 {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
