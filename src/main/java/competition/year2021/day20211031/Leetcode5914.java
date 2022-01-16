package competition.year2021.day20211031;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211031
 * @ClassName: Leetcode5914
 * @Author: markey
 * @Description:
 * @Date: 2021/10/31 21:01
 * @Version: 1.0
 */
public class Leetcode5914 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
