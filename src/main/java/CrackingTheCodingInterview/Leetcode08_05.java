package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_05
 * @Author: markey
 * @Description:
 * @Date: 2020/9/26 23:35
 * @Version: 1.0
 */
public class Leetcode08_05 {
    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        } else if (B < 0) {
            return 0 - multiply(A, 0 - B);
        } else if (B >= 2 && B % 2 == 0) {
            A <<= 1;
            B >>= 1;
            return multiply(A, B);
        } else {
            return A + multiply(A, B - 1);
        }
    }
}
