package competition.day20210411;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210411
 * @ClassName: Leetcode5726
 * @Author: markey
 * @Description:
 * @Date: 2021/4/11 10:30
 * @Version: 1.0
 */
public class Leetcode5726 {
    public int arraySign(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                result *= -1;
            }
            if (nums[i] == 0) {
                return 0;
            }
        }
        return result;
    }
}
