package competition.year2020.day20200503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200503
 * @ClassName: Matrix5403
 * @Author: markey
 * @Description:
 * @Date: 2020/5/3 11:07
 * @Version: 1.0
 */
public class Matrix5403 {
    public static void main(String[] args) {
        int[][] x = new int[][] {{1,3,11},{2,4,6}};
        System.out.println(kthSmallest(x,5));
    }
    public static int kthSmallest(int[][] mat, int k) {
        int[][] min = new int[mat.length][mat[0].length];
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min[i].length; j++) {
                min[i][j] = j > 0 ? mat[i][j] - mat[i][j-1] : mat[i][j];
            }
        }

        int[] indexs = new int[mat.length];
        List<int[]> res = new ArrayList<>();
        res.add(Arrays.copyOfRange(indexs, 0, indexs.length));

        while (res.size() < k) {
            int index = -1;
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < indexs.length; j++) {
                if (indexs[j] + 1 >= mat[j].length) {
                    continue;
                }
                if (min[j][indexs[j] + 1] < temp) {
                    index = j;
                    temp = min[j][indexs[j] + 1];
                }
            }
            indexs[index]++;
            int size = res.size();
            for (int i = 0; i < size; i++) {
                int[] copy = Arrays.copyOfRange(res.get(i), 0, res.get(0).length);
                copy[index] = indexs[index];
                res.add(copy);
            }
            res.forEach(x -> System.out.println(Arrays.toString(x)));
            System.out.println();
        }
        int[] resIndex = res.get(k-1);
        int sum = 0;
        for (int i = 0; i < resIndex.length; i++) {
            sum += mat[i][resIndex[i]];
        }
        return sum;
    }
}
