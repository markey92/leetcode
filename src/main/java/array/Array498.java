package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array498
 * @Author: markey
 * @Description:498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *  
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 解释:
 *
 *  
 *
 * 说明:
 *
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/1 22:55
 * @Version: 1.0
 */
public class Array498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int x = 0, y = 0;
        boolean up = true;
        List<Integer> res = new ArrayList<>();
        while (x < matrix.length && y < matrix[x].length) {
            res.add(matrix[x][y]);
            if (x == matrix.length - 1 && !up){
                y++;
                up = true;
            } else if (y == 0 && !up) {
                x++;
                up = true;
            } else if (y == matrix[x].length - 1 && up) {
                x++;
                up = false;
            } else if (x == 0 && up) {
                y++;
                up = false;
            } else {
                if (up) {
                    x--;
                    y++;
                } else {
                    x++;
                    y--;
                }
            }
            System.out.println(x + " " + y);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
