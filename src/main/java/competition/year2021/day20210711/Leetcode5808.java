package competition.year2021.day20210711;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210711
 * @ClassName: Leetcode5808
 * @Author: markey
 * @Description:
 * @Date: 2021/7/11 10:30
 * @Version: 1.0
 */
public class Leetcode5808 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[n * 2];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
            res[n + i] = nums[i];
        }
        return res;
    }
}
