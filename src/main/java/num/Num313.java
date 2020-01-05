package num;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Num313
 * @Author: markey
 * @Description:
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 *
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/5 20:31
 * @Version: 1.0
 */
public class Num313 {

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[] {2,7,13,19}));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] countForPrime = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        int count = 1;
        while (count < n) {
            int min = 0;
            int usePrime = 0;
            for (int i = 0; i < primes.length; i++) {
                if (min == 0) {
                    min = primes[i] * result[countForPrime[i]];
                    usePrime = i;
                    continue;
                }
                if (primes[i] * result[countForPrime[i]] < min) {
                    min = primes[i] * result[countForPrime[i]];
                    usePrime = i;
                }
            }
            countForPrime[usePrime]++;
            if (min == result[count - 1]) {
                continue;
            } else {
                result[count++] = min;
            }
        }
        return result[n-1];
    }
}
