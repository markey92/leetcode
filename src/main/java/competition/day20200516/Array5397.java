package competition.day20200516;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200516
 * @ClassName: Array5397
 * @Author: markey
 * @Description:
 * @Date: 2020/5/16 22:36
 * @Version: 1.0
 */
public class Array5397 {
    public static void main(String[] args) {
        System.out.println(simplifiedFractions(6));
    }
    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (j == 1 || isOk(j, i)) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    private static boolean isOk(int x, int y) {
        if (x > y) {
            return isOk(y, x);
        }
        if (y % x == 0) {
            return x == 1;
        } else {
            return isOk(y - x, x);
        }
    }
}
