package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF46
 * @Author: markey
 * @Description:面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/28 23:12
 * @Version: 1.0
 */
public class LCOF46 {
    public static void main(String[] args) {
        System.out.println(translateNum(1225));
    }
    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        int difference = 97; //'a' - 0 = 97
        int result = translateNum(num / 10);
        if (num % 100 <= 25 && num % 100 != num % 10) {
            result += translateNum(num / 100);
        }
        System.out.println(result);
        return result;
    }
}
