package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array961
 * @Author: markey
 * @Description:
 * @Date: 2020/5/27 22:05
 * @Version: 1.0
 */
public class Array961 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                return A[i];
            } else {
                set.add(A[i]);
            }
        }
        return 0;
    }
}
