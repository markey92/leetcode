package num;

import java.util.PriorityQueue;

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

    public static void main(String[] args) {

        int[][] matrix = {{1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    /**
     * 因为每一行都是有序的，所以每一行的最小值（最左边）中最小一个必定是矩阵的最小值。
     * 取出这个最小值（即整个矩阵的最小值），同时使用这一行的下一个元素参与下一次比较。
     * 循环上述步骤直到取到第k个最小值。
     * 执行用时 :65 ms, 在所有 Java 提交中击败了14.68%的用户
     * 内存消耗 :44 MB, 在所有 Java 提交中击败了92.68%的用户
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length; // 行数
        int col = matrix[0].length; // 列数
        int[] countForRow = new int[row]; // 每一行的指针
        //维护一个最小堆,堆里记录行数，
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (i1, i2) -> matrix[i1][countForRow[i1]] - matrix[i2][countForRow[i2]]);
        for (int i = 0; i < row; i++) {
            heap.add(i);
        }
        int count = 1;
        while (count < k) {
            int post = heap.poll();
            countForRow[post]++;
            if (countForRow[post] < col) {
                heap.add(post);
            }
            count++;
        }
        return matrix[heap.peek()][countForRow[heap.peek()]];
    }
}
