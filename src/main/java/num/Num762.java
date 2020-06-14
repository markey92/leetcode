package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num762
 * @Author: markey
 * @Description:
 * @Date: 2020/6/9 23:24
 * @Version: 1.0
 */
public class Num762 {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(getBit(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    private int getBit(int x) {
        int count = 0;
        while (x > 0) {
            count += x & 1;
            x >>= 1;
        }
        return count;
    }
}
