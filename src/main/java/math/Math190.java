package math;

/**
 * @ProjectName: leetcode
 * @Package: math
 * @ClassName: Math190
 * @Author: markey
 * @Description:
 * @Date: 2020/5/11 22:34
 * @Version: 1.0
 */
public class Math190 {
    public int reverseBits(int n) {
        int res = 0;
        while (n != 0) {
            res = n & 1;
            n >>= 1;
            res <<= 1;
        }
        return res;
    }
}
