package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array69
 * @Author: markey
 * @Description:
 * @Date: 2020/5/9 0:31
 * @Version: 1.0
 */
public class Array69 {
    public int mySqrt(int x) {
        return mySqrt(x, 1, x);
    }

    public int mySqrt(int x, int start, int end) {
        if (start >= end) {
            return end;
        }
        int middle = (start + end) / 2 + 1;
        if (x / middle < middle) {
            return mySqrt(x, start, middle - 1);
        }
        if (x / middle > middle) {
            return mySqrt(x, middle, end);
        }
        System.out.println(middle);
        return middle;
    }
}
