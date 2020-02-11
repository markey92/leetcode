package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF64
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 23:17
 * @Version: 1.0
 */
public class LCOF64 {
    public int sumNums(int n) {
        return sumNums(1, n);
    }

    private int sumNums(int start, int end) {
        return start == end ? end : start + sumNums(start + 1, end);
    }
}
