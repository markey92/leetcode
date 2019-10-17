package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array905
 * @Author: markey
 * @Description:
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:05
 * @Version: 1.0
 */
public class Array905 {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array By Parity.
     * Memory Usage: 40.3 MB, less than 92.36% of Java online submissions for Sort Array By Parity.
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = A.length - 1; i < j;) {
            if (A[i] %2 == 0) {
                i++;
                continue;
            }
            if (A[j] %2 == 1) {
                j--;
                continue;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        return A;
    }
}
