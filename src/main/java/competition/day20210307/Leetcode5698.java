package competition.day20210307;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210307
 * @ClassName: Leetcode5698
 * @Author: markey
 * @Description:
 * @Date: 2021/3/7 10:48
 * @Version: 1.0
 */
public class Leetcode5698 {
    public int minElements(int[] nums, int limit, int goal) {
        int n = nums.length;
        int res = goal / limit;
        goal = goal % limit;
        System.out.println(res + ":" + goal);
        for (int i = 0; i < n; i++) {
            goal -= nums[i];
            if (Math.abs(goal) > limit) {
                res += goal / limit;
                goal = goal % limit;
            }
            System.out.println(res + ":" + goal);
        }
        if (goal > 0 && res >= 0) {
            res += 1;
        }
        if (goal < 0 && res <= 0) {
            res -= 1;
        }
        return Math.abs(res);
    }
}
