package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF57_2
 * @Author: markey
 * @Description:
 * @Date: 2020/2/17 22:38
 * @Version: 1.0
 */
public class LCOF57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int start = 1, end = 2;
        while (end < target) {
            if (sum(start, end) < target) {
                end++;
                continue;
            }
            if (sum(start, end) > target) {
                start++;
                continue;
            }
            int[] result = new int[end - start + 1];
            for (int i = 0; i < end - start + 1; i++) {
                result[i] = (start + i);
            }
            res.add(result);
            start ++;
            end ++;
        }
        return res.toArray(new int[0][]);
    }
    private int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end ; i++) {
            sum += i;
        }
        return sum;
    }
}
