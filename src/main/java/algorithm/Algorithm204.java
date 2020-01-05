package algorithm;

/**
 * @ProjectName: leetcode
 * @Package: algorithm
 * @ClassName: Algorithm204
 * @Author: markey
 * @Description:
 * @Date: 2019/10/17 22:12
 * @Version: 1.0
 */
public class Algorithm204 {

    /**
     * 执行用时 :26 ms, 在所有 java 提交中击败了78.08%的用户
     * 内存消耗 :40.5 MB, 在所有 java 提交中击败了6.31%的用户
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int[] all = new int[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (all[i] == 0) {
                result ++;
                int j = i + i;
                while (j < n) {
                    all[j] = 1;
                    j += i;
                }
            }
        }
        return result;
    }
}
