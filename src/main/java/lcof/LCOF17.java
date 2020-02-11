package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF17
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 22:40
 * @Version: 1.0
 */
public class LCOF17 {

    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        int[] res = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
