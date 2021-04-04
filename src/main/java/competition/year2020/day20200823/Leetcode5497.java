package competition.year2020.day20200823;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200823
 * @ClassName: Leetcode5497
 * @Author: markey
 * @Description:
 * @Date: 2020/8/23 10:56
 * @Version: 1.0
 */
public class Leetcode5497 {
    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) {
            return m;
        }
        List<int[]> temp = new ArrayList<>();
        int n = arr.length;
        temp.add(new int[] {1, n});
        for (int i = n - 1; i >= 0; i--) {
            insert(temp, arr[i]);
            temp.forEach(x -> System.out.println(Arrays.toString(x)));
            boolean hasBiggerThanM = false;
            for (int j = 0; j < temp.size(); j++) {
                int[] x = temp.get(j);
                if (x[1] - x[0] + 1 > m) {
                    hasBiggerThanM = true;
                    continue;
                }
                if (x[1] - x[0] + 1 == m) {
                    return i;
                }
            }
            if (!hasBiggerThanM) {
                break;
            }
        }
        return -1;
    }

    private void insert(List<int[]> temp, int n) {
        for (int i = 0; i < temp.size(); i++) {
            int[] x = temp.get(i);
            if (x[0] <= n && x[1] >= n) {
                temp.remove(x);
                if (n - 1 >= x[0]) {
                    temp.add(new int[] {x[0], n - 1});
                }
                if (n + 1 <= x[1]) {
                    temp.add(new int[] {n + 1, x[1]});
                }
            }
        }
    }
}
