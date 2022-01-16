package competition.year2021.day20211212;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211212
 * @ClassName: Leetcode5953
 * @Author: markey
 * @Description:
 * @Date: 2021/12/12 10:37
 * @Version: 1.0
 */
public class Leetcode5953 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long min;
        long max;
        long res = 0;
        for (int i = 0; i < n; i++) {
            min = nums[i];
            max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}
