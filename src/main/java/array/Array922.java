package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array922
 * @Author: markey
 * @Description:
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:06
 * @Version: 1.0
 */
public class Array922 {

    /**
     * 执行用时 :3 ms, 在所有 java 提交中击败了97.24%的用户
     * 内存消耗 :40.4 MB, 在所有 java 提交中击败了95.19%的用户
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = A.length -1;
        while (i < A.length) {
            if (A[i]%2 == 0) {
                i += 2;
                continue;
            }
            if (A[j]%2 != 0) {
                j -= 2;
                continue;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i += 2;
            j -= 2;
        }
        return A;
    }
}
