package competition.year2020.day20200802;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200802
 * @ClassName: Array5475
 * @Author: markey
 * @Description:
 * @Date: 2020/8/2 10:34
 * @Version: 1.0
 */
public class Array5475 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j]-arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}
