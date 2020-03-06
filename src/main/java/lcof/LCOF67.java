package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF67
 * @Author: markey
 * @Description:面试题67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 *  
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *  
 *
 * 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/5 22:48
 * @Version: 1.0
 */
public class LCOF67 {
    public int strToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        // 去除头部空格
        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
            if (i >= str.length()) {
                return 0;
            }
        }
        str = str.substring(i);

        System.out.println(str);
        if (str.charAt(0) == '-') {
            return praseInt(false, str);
        } else if (str.charAt(0) == '+') {
            return praseInt(true, str.substring(1));
        } else if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return praseInt(true, str);
        } else {
            return 0;
        }
    }

    private int praseInt(boolean positive, String str) {
        // 负数的第一个字符应该是'-'
        int i =  positive ? 0 : 1;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            i++;
        }
        // 负数应该至少有两个字符， 正数至少有一个字符
        if (i <= 0 || !positive && i <= 1) {
            return 0;
        }
        String intStr = str.substring(0, i);
        if (positive && biggerThanMAX(intStr)) {
            return Integer.MAX_VALUE;
        }
        if (!positive && smallerThanMIN(intStr)) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(intStr);
    }

    private boolean biggerThanMAX(String str) {
        System.out.println(str);
        // 去除开头的0
        int start = 0;
        while (start < str.length() && str.charAt(start) == '0') {
            start++;
        }
        str = str.substring(start);
        // 逐个字符比较大小
        String max = String.valueOf(Integer.MAX_VALUE);
        if (str.length() > max.length()) {
            return true;
        }
        if (str.length() < max.length()) {
            return false;
        }
        for (int i = 0; i < max.length(); i++) {
            if (str.charAt(i) > max.charAt(i)) {
                return true;
            }
            if (str.charAt(i) < max.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    private boolean smallerThanMIN(String str) {
        // 去除开头的0
        int start = 1;
        while (start < str.length() && str.charAt(start) == '0') {
            start++;
        }
        str = "-" + str.substring(start);
        // 逐个字符比较大小
        String min = String.valueOf(Integer.MIN_VALUE);
        if (str.length() > min.length()) {
            return true;
        }
        if (str.length() < min.length()) {
            return false;
        }
        for (int i = 0; i < min.length(); i++) {
            if (str.charAt(i) > min.charAt(i)) {
                return true;
            }
            if (str.charAt(i) < min.charAt(i)) {
                return false;
            }
        }
        return false;
    }
}
