package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num1304
 * @Author: markey
 * @Description:
 * @Date: 2020/5/21 23:44
 * @Version: 1.0
 */
public class Num1304 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n / 2; i++) {
            res [i] = i + 1;
            res [i + n / 2] = 0 - res[i];
        }
        if (n % 2 == 1) {
            res[n-1] = 0;
        }
        return res;
    }
}
