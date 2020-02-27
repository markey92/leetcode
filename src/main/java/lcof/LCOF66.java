package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF66
 * @Author: markey
 * @Description:面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/25 22:45
 * @Version: 1.0
 */
public class LCOF66 {
    /**
     * 由题目知：B[i]就是i左边的数的乘积 乘以 右边的数的乘积
     * 使用对称遍历两次的方法，来存储左边数的乘积和右边数的乘积
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) {
            return new int[]{};
        }

        int[] left = new int[n], right = new int[n];
        left[0] = a[0];
        right[n - 1] = a[n - 1];
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i];
            right[n - 1 -i] = right[n - i] * a[i];
        }

        int[] res = new int[n];
        res[0] = right[1];
        res[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
}
