package num;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Num378
 * @Author: markey
 * @Description:
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/5 21:06
 * @Version: 1.0
 */
public class Num378 {

    public int kthSmallest(int[][] matrix, int k) {
        int x = matrix[0].length;
        int y = matrix.length;
        int i = k/x + 1;
        for (int j = 0; j < x; j++) {

        }
        return 0;
    }
}
