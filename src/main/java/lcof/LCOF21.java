package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LOCF25
 * @Author: markey
 * @Description:
 * @Date: 2020/2/12 23:39
 * @Version: 1.0
 */
public class LCOF21 {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
