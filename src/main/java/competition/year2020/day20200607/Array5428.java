package competition.year2020.day20200607;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200607
 * @ClassName: Array5428
 * @Author: markey
 * @Description:
 * @Date: 2020/6/7 10:30
 * @Version: 1.0
 */
public class Array5428 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[i + n];
        }
        return res;
    }
}
