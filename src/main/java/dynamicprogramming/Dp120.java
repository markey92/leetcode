package dynamicprogramming;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp120
 * @Author: markey
 * @Description:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:43
 * @Version: 1.0
 */
public class Dp120 {
    /**
     * 执行用时 :4 ms, 在所有 java 提交中击败了53.54%的用户
     * 内存消耗 :37.4 MB, 在所有 java 提交中击败了68.44%的用户
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] res = new int[n];
        res[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (j == i) {
                    res[j] = res[j - 1] + triangle.get(i).get(j);
                } else {
                    res[j] = Math.min(res[j - 1], res[j]) + triangle.get(i).get(j);
                }
            }
            res[0] += triangle.get(i).get(0);
            // sout(res);
        }
        int result = res[0];
        for (int i = 0; i < n; i++) {
            if (result > res[i]) {
                result = res[i];
            }
        }
        return result;
    }

    private void sout(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
