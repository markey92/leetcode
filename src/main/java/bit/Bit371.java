package bit;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: Bit371
 * @Author: markey
 * @Description:
 * @Date: 2020/6/9 23:45
 * @Version: 1.0
 */
public class Bit371 {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
