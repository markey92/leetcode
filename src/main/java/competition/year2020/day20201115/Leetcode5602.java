package competition.year2020.day20201115;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201115
 * @ClassName: Leetcode5602
 * @Author: markey
 * @Description:
 * @Date: 2020/11/15 10:48
 * @Version: 1.0
 */
public class Leetcode5602 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int traget = sum - x;
        if (traget < 0) {
            return -1;
        }
        int sumTemp = 0;
        int start = 0;
        int end = 0;
        int res = Integer.MAX_VALUE;
        while (start <= end && end < n) {
            System.out.println(sumTemp + ":" + start + ":" + end);
            if (sumTemp > traget) {
                sumTemp -= nums[start];
                start++;
            } else {
                sumTemp += nums[end];
                end++;
            }
            if (sumTemp == traget) {
                res = Math.min(n - (end - start), res);
                sumTemp -= nums[start];
                start++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
