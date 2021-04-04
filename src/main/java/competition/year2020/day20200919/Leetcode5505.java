package competition.year2020.day20200919;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200919
 * @ClassName: Leetcode5505
 * @Author: markey
 * @Description:
 * @Date: 2020/9/19 22:45
 * @Version: 1.0
 */
public class Leetcode5505 {
    /**
     * 差分思想
     * 先计算那个位置的出现频率最高
     * @param nums
     * @param requests
     * @return
     */
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;

        //计算那个位置的出现频率最高
        int[] countTemp = new int[n + 1]; // 开始位置加出现次数，结束位置的下一个位置减去出现次数

        for (int i = 0; i < requests.length; i++) {
            int[] request = requests[i];
            countTemp[request[0]] += 1;
            countTemp[request[1] + 1] -= 1;
        }

        // 根据上面结果推断每个位置的个数
        int[] count =  new int[n];
        count[0] = countTemp[0];
        for (int i = 1; i < n; i++) {
            count[i] = count[i - 1] + countTemp[i];
        }

        // 排序后，数字最大*频率最高
        Arrays.sort(nums);
        Arrays.sort(count);
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] <= 0) {
                break;
            }
            res += nums[i] * count[i];
            res %= 1000000007;
        }
        return (int) res;
    }
}
