package competition.year2021.day20210221;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210221
 * @ClassName: Leetcode5686
 * @Author: markey
 * @Description:
 * @Date: 2021/2/21 18:58
 * @Version: 1.0
 */
public class Leetcode5686 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int num = 0;
        for (int i = 1; i < n; i++) {
            num += boxes.charAt(i - 1) - '0';
            left[i] = left[i - 1] + num;
        }
        System.out.println(Arrays.toString(left));

        int[] right = new  int[n];
        num = 0;
        for (int i = n - 2; i >= 0; i--) {
            num += boxes.charAt(i + 1) - '0';
            right[i] = right[i + 1] + num;
        }
        System.out.println(Arrays.toString(right));

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}
