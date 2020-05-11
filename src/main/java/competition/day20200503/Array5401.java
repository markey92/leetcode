package competition.day20200503;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200503
 * @ClassName: Array5401
 * @Author: markey
 * @Description:
 * @Date: 2020/5/3 10:35
 * @Version: 1.0
 */
public class Array5401 {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = 0 - k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i-lastIndex-1 >= k) {
                    lastIndex = i;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
