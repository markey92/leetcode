package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num1009
 * @Author: markey
 * @Description:
 * @Date: 2020/6/9 23:35
 * @Version: 1.0
 */
public class Num1009 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int count = 0;
        int res = 0;
        while (N > 0) {
            System.out.println(N);
            System.out.println(N ^ 1);
            if ((N & 1) == 0) {
                res += (1 << count);
                System.out.println(res);
            }
            count++;
            N >>= 1;
        }
        return res;
    }
}
