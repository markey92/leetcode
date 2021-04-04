package competition.year2020.day20201017;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201017
 * @ClassName: Leetcode5122
 * @Author: markey
 * @Description:
 * @Date: 2020/10/17 22:30
 * @Version: 1.0
 */
public class Leetcode5122 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int start = (int) (arr.length * 0.95);
        int end = arr.length - start;
        int count = 0;
        double sum = 0.0;
        System.out.println(start + " " + end);
        for (int i = start; i < end; i++) {
            count++;
            sum += arr[i];
            System.out.println(count + " " + sum);
        }
        return sum / count;
    }
}
