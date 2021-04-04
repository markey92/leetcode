package competition.year2020.day20201025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201025
 * @ClassName: Leetcode5547
 * @Author: markey
 * @Description:
 * @Date: 2020/10/25 10:35
 * @Version: 1.0
 */
public class Leetcode5547 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int n = l.length;
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(temp);
            res.add(is(temp));
        }
        return res;
    }

    private boolean is(int[] x) {
        if (x.length <= 1) {
            return true;
        }
        int diff = x[1] - x[0];
        for (int i = 2; i < x.length; i++) {
            if (x[i] - x[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
