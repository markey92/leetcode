package sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: Sort75
 * @Author: markey
 * @Description:
 * @Date: 2020/5/28 22:06
 * @Version: 1.0
 */
public class Sort75 {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (int i = 0; count.containsKey(0) && i < count.get(0); i++, index++) {
            nums[index] = 0;
        }
        for (int i = 0; count.containsKey(1) && i < count.get(1); i++, index++) {
            nums[index] = 1;
        }
        for (int i = 0; count.containsKey(2) && i < count.get(2); i++, index++) {
            nums[index] = 2;
        }
    }

    /**
     * 三路快排
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while (cur < p2) {
            if (nums[cur] == 2) {
                nums[cur] = nums[p2];
                nums[p2] = 2;
                p2--;
            } else if (nums[cur] == 0) {
                nums[cur] = nums[p0];
                nums[p0] = 0;
                p0++;
                cur++;
            } else {
                cur++;
            }
        }
    }
}
