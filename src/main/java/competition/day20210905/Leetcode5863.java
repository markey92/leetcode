package competition.day20210905;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210905
 * @ClassName: Leetcode5863
 * @Author: markey
 * @Description:
 * @Date: 2021/9/5 10:33
 * @Version: 1.0
 */
public class Leetcode5863 {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < k; l++) {
                        if (nums[l] + nums[k] + nums[j] == nums[i]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
