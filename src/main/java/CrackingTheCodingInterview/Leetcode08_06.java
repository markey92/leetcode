package CrackingTheCodingInterview;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_06
 * @Author: markey
 * @Description: 汉诺塔移动
 * @Date: 2020/9/12 21:40
 * @Version: 1.0
 */
public class Leetcode08_06 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A, B, C, A.size());
    }

    /**
     * 吧n个盘中从A移到C，B作为辅助
     * @param A
     * @param B
     * @param C
     * @param n
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        System.out.println("A:" + A);
        System.out.println("B:" + B);
        System.out.println("C:" + C);
        System.out.println();
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
        } else {
            hanota(A, C, B, n - 1); // 先吧A的N-1都移到B上，
            C.add(A.remove(A.size() - 1)); // 吧A的第N个盘子移到C
            hanota(B, A, C, n - 1);
        }

    }
}
