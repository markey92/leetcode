package other;

/**
 * @ProjectName: leetcode
 * @Package: other
 * @ClassName: Bit136
 * @Author: markey
 * @Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:30
 * @Version: 1.0
 */
public class Bit136 {
    /**
     * 概念
     *
     * 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
     * a \oplus 0 = aa⊕0=a
     * 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
     * a \oplus a = 0a⊕a=0
     * XOR 满足交换律和结合律
     * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * 所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
     * Memory Usage: 39.1 MB, less than 97.04% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result ^= num;
        }
        return result;
    }
}
