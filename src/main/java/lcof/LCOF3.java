package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF3
 * @Author: markey
 * @Description:
 * @Date: 2020/2/13 0:34
 * @Version: 1.0
 */
public class LCOF3 {
    public int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i;
        for ( i = 0; i < nums.length; i++) {
            if (list.indexOf(nums[i]) != -1) {
                break;
            } else {
                list.add(nums[i]);
            }
        }
        return nums[i];
    }
}
