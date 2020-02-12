package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF56_1
 * @Author: markey
 * @Description:
 * @Date: 2020/2/13 0:01
 * @Version: 1.0
 */
public class LCOF56_1 {
    public int[] singleNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove(list.indexOf(nums[0]));
            } else {
                list.add(nums[i]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
