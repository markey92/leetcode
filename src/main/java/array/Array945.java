package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array945
 * @Author: markey
 * @Description:945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/22 17:09
 * @Version: 1.0
 */
public class Array945 {
    public int minIncrementForUnique(int[] A) {
        int[] help = new int[80001];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int index = A[i];
            while (help[index] != 0) {
                res++;
                index++;
            }
            help[index] = 1;
        }
        return res;
    }
}
