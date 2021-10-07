package competition.year2021.day20210321;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210321
 * @ClassName: Leetcode5711
 * @Author: markey
 * @Description:
 * @Date: 2021/3/21 11:31
 * @Version: 1.0
 */
public class Leetcode5711 {
    public static void main(String[] args) {
        System.out.println(count(2, 3));
        System.out.println(count(4,3));
    }
    public int maxValue(int n, int index, int maxSum) {
        int leftNum = index - 0;
        int rightNum = n - 1 - index;
        int left = 1, right = maxSum;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            int count = mid + count(mid, leftNum) + count(mid, rightNum);
            if (count > maxSum) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int count(int start, int num) {
        int end = Math.max(1, start - num + 1);
        return (start + end) * (start - end + 1) / 2 + Math.max(0, num - start) * 1;
    }
}
