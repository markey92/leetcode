package competition.year2020.day20201031;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201031
 * @ClassName: Leetcode5539
 * @Author: markey
 * @Description:
 * @Date: 2020/10/31 22:30
 * @Version: 1.0
 */
public class Leetcode5539 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        return Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (count.get(o1) == count.get(o2)) {
                    return o2 - o1;
                } else {
                    return count.get(o1) - count.get(o2);
                }
            }
        }).mapToInt(Integer::intValue).toArray();
    }
}
