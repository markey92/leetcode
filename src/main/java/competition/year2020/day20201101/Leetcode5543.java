package competition.year2020.day20201101;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201101
 * @ClassName: Leetcode55543
 * @Author: markey
 * @Description:
 * @Date: 2020/11/1 10:41
 * @Version: 1.0
 */
public class Leetcode5543 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            index.put(arr[i], i);
        }
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 1; j < pieces[i].length; j++) {
                if (index.getOrDefault(pieces[i][j], -1) - index.getOrDefault(pieces[i][j - 1], -1) != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
