package competition.year2020.day20200830;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200830
 * @ClassName: Leetcode5499
 * @Author: markey
 * @Description:
 * @Date: 2020/8/30 10:32
 * @Version: 1.0
 */
public class Leetcode5499 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int start = 0;
        while (start <= arr.length - m * k) {
            if (match(arr, start, m, k)) {
                return true;
            } else {
                start++;
            }
        }
        return false;
    }

    private boolean match(int[] arr, int start, int m, int k) {
        System.out.println("start " + start);
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(arr[start + i * m + j] + " " + arr[start + m * (i - 1) + j]);
                if (arr[start + i * m + j] != arr[start + m * (i - 1) + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
