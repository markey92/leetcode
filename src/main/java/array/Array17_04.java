package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array17_04
 * @Author: markey
 * @Description:
 * @Date: 2020/5/28 21:52
 * @Version: 1.0
 */
public class Array17_04 {
    public int missingNumber(int[] nums) {
        int[] tag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tag[nums[i]] = 1;
        }
        for (int i = 0; i < tag.length; i++) {
            if (tag[i] != 1) {
                return i;
            }
        }
        return 0;
    }
}
