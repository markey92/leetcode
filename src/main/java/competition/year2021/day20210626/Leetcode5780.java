package competition.year2021.day20210626;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210626
 * @ClassName: Leetcode5780
 * @Author: markey
 * @Description:
 * @Date: 2021/6/26 22:30
 * @Version: 1.0
 */
public class Leetcode5780 {
    public boolean canBeIncreasing(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(numList);
            temp.remove(i);
            if (isCreasing(temp)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCreasing(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
