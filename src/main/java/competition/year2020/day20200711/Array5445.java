package competition.year2020.day20200711;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200711
 * @ClassName: Array5445
 * @Author: markey
 * @Description:
 * @Date: 2020/7/11 22:38
 * @Version: 1.0
 */
public class Array5445 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int count = n * (n + 1) / 2;
        int[] newNums = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            newNums[index] = nums[i];
            index++;
            for (int j = i + 1; j < nums.length; j++) {
                newNums[index] = newNums[index - 1] + nums[j];
                index++;
            }
        }
        Arrays.sort(newNums);
        System.out.println(Arrays.toString(newNums));
        long res = 0;
        for (int i = left - 1; i < right; i++) {
            res += newNums[i];
            res %=  1000000007;
        }
        return (int) res;
    }
}
