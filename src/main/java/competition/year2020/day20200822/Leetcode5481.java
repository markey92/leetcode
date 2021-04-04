package competition.year2020.day20200822;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200822
 * @ClassName: Leetcode5481
 * @Author: markey
 * @Description:
 * @Date: 2020/8/22 22:41
 * @Version: 1.0
 */
public class Leetcode5481 {
    public int minOperations(int[] nums) {
        int maxCount = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int countTemp = 0;
            while (temp > 0) {
                if ((temp & 1) > 0) {
                    sum++;
                }
                temp = temp >> 1;
                countTemp++;
            }
            if (countTemp > maxCount) {
                maxCount = countTemp;
            }
        }
        System.out.println(sum);
        System.out.println(maxCount);
        return sum + maxCount - 1;
    }
}
