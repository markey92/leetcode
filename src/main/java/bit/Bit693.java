package bit;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: Bit693
 * @Author: markey
 * @Description:
 * @Date: 2020/6/5 23:05
 * @Version: 1.0
 */
public class Bit693 {
    public boolean hasAlternatingBits(int n) {
        int last = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == last) {
                return false;
            } else {
                last = n & 1;
                n >>= 1;
            }
        }
        return true;
    }
}
