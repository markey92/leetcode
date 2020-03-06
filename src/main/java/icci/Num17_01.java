package icci;

/**
 * @ProjectName: leetcode
 * @Package: icci
 * @ClassName: Num17_01
 * @Author: markey
 * @Description:
 * @Date: 2020/3/3 23:46
 * @Version: 1.0
 */
public class Num17_01 {
    public int add(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}
