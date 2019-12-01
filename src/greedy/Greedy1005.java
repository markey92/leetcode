package greedy;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: greedy
 * @ClassName: Greedy1005
 * @Author: markey
 * @Description:
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 *
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 *
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1  20:59
 * @Version: 1.0
 */
public class Greedy1005 {
    /**
     * 排序后取最小值取反，此时得到的数组和最大
     * 循环K次，效率较低。
     * 有更繁琐的解法：
     * 将所有数字先求和sum，
     * 然后number数组记录所有负数出现的次数，index记录最小正整数，i从-100到-1.K>0时反转负数，
     * 比如i=-3变成+3，会使得sum增加2\times×i\times×number[i]。
     * 当K为0时返回结果，遍历结束后K如果仍然大于0，就检查它的奇偶性，
     * 若为奇数，就将最小的那个正数反转为负数
     * Runtime: 67 ms, faster than 5.54% of Java online submissions for Maximize Sum Of Array After K Negations.
     * Memory Usage: 37.2 MB, less than 94.12% of Java online submissions for Maximize Sum Of Array After K Negations.
     * @param A
     * @param K
     * @return
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        while (K > 0) {
            Arrays.sort(A);
            A[0] = 0 - A[0];
            K --;
        }
        return Arrays.stream(A).sum();
    }
}
