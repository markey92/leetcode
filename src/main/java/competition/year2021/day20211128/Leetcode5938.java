package competition.year2021.day20211128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.year2021.day20211128
 * @ClassName: Leetcode5938
 * @Author: markey
 * @Description:
 * @Date: 2021/11/28 10:31
 * @Version: 1.0
 */
public class Leetcode5938 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }
}
