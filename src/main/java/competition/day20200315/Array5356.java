package competition.day20200315;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200315
 * @ClassName: Array5356
 * @Author: markey
 * @Description:
 * @Date: 2020/3/15 10:32
 * @Version: 1.0
 */
public class Array5356 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> maybeLuckyNumbers = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < temp) {
                    temp  = matrix[i][j];
                }
            }
            maybeLuckyNumbers.add(temp);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int temp = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] > temp) {
                    temp = matrix[j][i];
                }
            }
            if (maybeLuckyNumbers.contains(temp)) {
                res.add(temp);
            }
        }
        return res;
    }
}
