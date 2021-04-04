package competition.day20210124;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210124
 * @ClassName: Leetcode5663
 * @Author: markey
 * @Description:
 * @Date: 2021/1/24 11:16
 * @Version: 1.0
 */
public class Leetcode5663 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);
        for (int i = 1; i < m; i++) {
            matrix[i][0] = matrix[i - 1][0] ^ matrix[i][0];
            res.add(matrix[i][0]);
        }
        for (int i = 1; i < n; i++) {
            matrix[0][i] = matrix[0][i - 1] ^ matrix[0][i];
            res.add(matrix[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] ^ matrix[i][j - 1] ^ matrix[i - 1][j] ^ matrix[i][j];
                res.add(matrix[i][j]);
            }
        }
        System.out.println(res);
        return res.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(k - 1);
    }
}
