package dynamicprogramming;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp1314
 * @Author: markey
 * @Description:
 * @Date: 2020/3/22 22:24
 * @Version: 1.0
 */
public class Dp1314 {
    //保存所有节点的前缀和，然后再遍历得出结论
    public int[][] matrixBlockSum(int[][] mat, int K) {
        if (mat.length == 0) {
            return new int[0][0];
        }
        int[][] prefixSum = prefixSum(mat);
        for (int i = 0; i < prefixSum.length; i++) {
            System.out.println(Arrays.toString(prefixSum[i]));
        }
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                int row1 = i - K - 1, col1 = j - K - 1;
                int row2 = (i + K) >= res.length ? res.length - 1 : (i + K);
                int col2 = (j + K) >= res[i].length ? res[i].length - 1 : (j + K);
                System.out.println(row1 + " " + col1 + " " + row2 + " " + col2);
                res[i][j] += prefixSum[row2][col2];
                if (row1 >= 0 && col1 >=0) {
                    res[i][j] += prefixSum[row1][col1];
                }
                if (row1 >= 0) {
                    res[i][j] -= prefixSum[row1][col2];
                }
                if (col1 >= 0) {
                    res[i][j] -= prefixSum[row2][col1];
                }
                System.out.println(res[i][j]);
            }
        }
        return res;
    }

    // 构造前缀和矩阵
    private int[][] prefixSum(int[][] mat) {
        int[][] prefixSum = new int[mat.length][mat[0].length];
        prefixSum[0][0] = mat[0][0];
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = mat[i][j];
                if (i - 1 >= 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j - 1 >= 0) {
                    prefixSum[i][j] += prefixSum[i][j-1];
                }
                if (i - 1 > 0 && j - 1 > 0) {
                    prefixSum[i][j] -= prefixSum[i-1][j-1];
                }
            }
        }
        return prefixSum;
    }
}
