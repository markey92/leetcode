package heap;

import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap973
 * @Author: markey
 * @Description:
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/6 10:25
 * @Version: 1.0
 */
public class Heap973 {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] result = kClosest(points, K);
        System.out.println(kClosest(points, K));
    }

    /**
     * 使用优先队列，每次可以获得最小的元素
     * 执行用时 :71 ms, 在所有 Java 提交中击败了38.38%的用户
     * 内存消耗 :60.4 MB, 在所有 Java 提交中击败了94.35%的用户
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((int[] i1, int[] i2) -> {
            return (i1[0] * i1[0] + i1[1] * i1[1]) - (i2[0] * i2[0] + i2[1] * i2[1]);
        });

        for (int i = 0; i < points.length; i++) {
            minHeap.add(points[i]);
        }
        int[][] result = new int[K][points[0].length];
        for (int i = 0; i < K; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
