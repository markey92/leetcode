package string;

import com.sun.deploy.util.StringUtils;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String125
 * @Author: markey
 * @Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/8 18:46
 * @Version: 1.0
 */
public class String125 {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!isValid(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isValid(s.charAt(end))) {
                end--;
                continue;
            }
            if (equals(s.charAt(start), s.charAt(end))) {
                start++;
                end--;
            } else {
                System.out.println(start + " " + end);
                return false;
            }
        }
        return true;
    }
    private static boolean equals(char a, char b) {
        if (a == b) {
            return true;
        }
        if (a <= 'z' && a >= 'a') {
            return a - b == 32;
        }
        if (a <= 'Z' && a >= 'A') {
            return b - a == 32;
        }
        return false;
    }
    private static boolean isValid(char c) {
        if (c <= '9' && c >= '0') {
            return true;
        }
        if (c <= 'z' && c >= 'a') {
            return true;
        }
        if (c <= 'Z' && c >= 'A') {
            return true;
        }
        return false;
    }
}
