package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF49
 * @Author: markey
 * @Description:
 * @Date: 2020/2/17 23:24
 * @Version: 1.0
 */
public class LCOF49 {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int count = 1;
        int count2 = 0, count3 = 0, count5 = 0;
        while (count < n) {
            int num2 = uglyNums[count2] * 2;
            int num3 = uglyNums[count3] * 3;
            int num5 = uglyNums[count5] * 5;
            int min = Math.min(Math.min(num2, num3), num5);
            uglyNums[count] = min;
            if (min == num2) {
                count2++;
            }
            if (min == num3) {
                count3++;
            }
            if (min == num5) {
                count5++;
            }
            count++;
        }
        return uglyNums[n-1];
    }
}
