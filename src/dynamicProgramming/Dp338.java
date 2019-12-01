package dynamicProgramming;

public class Dp338 {
    /**
     * Runtime: 2 ms, faster than 32.14% of Java online submissions for Counting Bits.
     * Memory Usage: 38.8 MB, less than 5.88% of Java online submissions for Counting Bits.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            if (i == 0) {
                res[i] = 0;
            } else if (i == 1 || i == 2) {
                res[i] = 1;
            } else if (i % 2 == 0) {
                //偶数情况，例如 6:110； 3:11。二进制运算
                res[i] = res[i/2];
            } else {
                //奇数情况，前一个数（偶数）+1
                res[i] = res[i-1] + 1;
            }
        }
        return res;
    }
}
