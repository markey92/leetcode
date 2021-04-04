package competition.year2020.day20201114;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201114
 * @ClassName: Leetcode5550
 * @Author: markey
 * @Description:
 * @Date: 2020/11/14 22:31
 * @Version: 1.0
 */
public class Leetcode5550 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                res[i] = 0;
            }

        } else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                res[i] = sum(code, i + 1, k);
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                res[i] = sumLeft(code, i - 1, -k);
            }
        }
        return res;
    }

    private int sum(int[] code, int i, int k) {
        int sum = 0;
        while (k > 0) {
            if (i >= code.length) {
                i = i - code.length;
            }
            sum += code[i];
            i++;
            k--;
        }
        return sum;
    }

    private int sumLeft(int[] code, int i, int k) {
        int sum = 0;
        while (k > 0) {
            if (i < 0) {
                i = code.length - 1;
            }
            sum += code[i];
            i--;
            k--;
        }
        return sum;
    }
}
