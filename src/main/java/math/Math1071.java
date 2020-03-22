package math;

/**
 * @ProjectName: leetcode
 * @Package: math
 * @ClassName: Math1071
 * @Author: markey
 * @Description:1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/12 21:34
 * @Version: 1.0
 */
public class Math1071 {
    public String gcdOfStrings(String str1, String str2) {
        // 如果A+B 不等于B+A的话，说明他们没有公约数
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 假设最大公约字符串为x，则A=m*X，B=n*X；X的长度等于A和B的长度的最大公约数w
        // 知道了长度之后，因为A和B都是X的翻倍，所有X直接就是A的前w位字符
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    // 辗转相除法求最大公约数
    private int gcd(int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }
}
