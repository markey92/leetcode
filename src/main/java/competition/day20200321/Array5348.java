package competition.day20200321;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200321
 * @ClassName: Array5348
 * @Author: markey
 * @Description:5348. 两个数组间的距离值
 *
 * @Date: 2020/3/21 22:30
 * @Version: 1.0
 */
public class Array5348 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean ok = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    ok = false;
                }
            }
            if (ok) {
                res++;
            }
        }
        return res;
    }
}
