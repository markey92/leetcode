package num;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num908
 * @Author: markey
 * @Description:
 * @Date: 2020/5/23 22:53
 * @Version: 1.0
 */
public class Num908 {
    public int smallestRangeI(int[] A, int K) {
        int max = Arrays.stream(A).max().getAsInt();
        int min = Arrays.stream(A).min().getAsInt();
        return (max - min) > (K * 2) ? (max - min - K * 2) : 0;
    }
}
