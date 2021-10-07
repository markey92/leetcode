package competition.year2021.day20210207;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210207
 * @ClassName: Leetcode5672
 * @Author: markey
 * @Description:
 * @Date: 2021/2/7 20:51
 * @Version: 1.0
 */
public class Leetcode5672 {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 0 ? true: nums[0] > nums[nums.length - 1];
    }
}
