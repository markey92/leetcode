package competition.day20200202;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200202
 * @ClassName: List1337
 * @Author: markey
 * @Description:
 * @Date: 2020/3/12 22:33
 * @Version: 1.0
 */
public class List1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> power = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                power.put(i, power.getOrDefault(i, 0) + mat[i][j]);
            }
        }
        int[] cols = new int[mat.length];
        for (int i = 0; i < cols.length; i++) {
            cols[i] = i;
        }
        cols = Arrays.stream(cols).boxed().sorted((a, b) -> power.get(a) - power.get(b)).mapToInt(Integer::intValue).toArray();
        return Arrays.copyOf(cols, k);
    }
}
