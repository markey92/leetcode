package competition.year2021.day20210606;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210606
 * @ClassName: Leetcode5776
 * @Author: markey
 * @Description:
 * @Date: 2021/6/6 10:31
 * @Version: 1.0
 */
public class Leetcode5776 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean res = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    res = false;
                }
            }
            if (res == false) {
                break;
            }
        }
        if (res) {
            return true;
        }
        res = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[j][n - 1 - i]) {
                    res = false;
                }
            }
            if (res == false) {
                break;
            }
        }
        if (res) {
            return true;
        }
        res = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    res = false;
                }
            }
            if (res == false) {
                break;
            }
        }
        if (res) {
            return true;
        }
        res = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[n - 1 - j][i]) {
                    res = false;
                }
            }
            if (res == false) {
                break;
            }
        }
        return res;
    }
}
