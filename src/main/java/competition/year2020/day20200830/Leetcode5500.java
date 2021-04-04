package competition.year2020.day20200830;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200830
 * @ClassName: Leetcode5500
 * @Author: markey
 * @Description:
 * @Date: 2020/8/30 10:55
 * @Version: 1.0
 */
public class Leetcode5500 {
    public int getMaxLen(int[] nums) {
        int maxPositiveLength = 0;
        int maxDegativeLength = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxPositiveLength += 1;
                maxDegativeLength = maxDegativeLength == 0 ? 0 : maxDegativeLength + 1;
                max = Math.max(max, maxPositiveLength);
            } else if (nums[i] < 0) {
                int temp = maxPositiveLength;
                maxPositiveLength = maxDegativeLength > 0 ? maxDegativeLength + 1 : 0;
                maxDegativeLength = temp + 1;
                max = Math.max(max, maxPositiveLength);
            } else {
                maxDegativeLength = 0;
                maxPositiveLength = 0;
            }
            System.out.println(maxPositiveLength + " " + maxDegativeLength);
        }
        return max;
    }
}
