package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num43
 * @Author: markey
 * @Description:43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/22 21:46
 * @Version: 1.0
 */
public class Num43 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "0"));
    }
    public static String multiply(String num1, String num2) {
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            System.out.println(num2.charAt(i) - '0');
            StringBuilder multiply = multiply(num1, num2.charAt(i) - '0');

            for (int j = 0; j < num2.length() - 1 - i; j++) {
                multiply.append("0");
            }
            res = add(res, multiply.toString());
        }
        return praseZero(res);
    }

    public static StringBuilder multiply(String num, int x) {
        if (x == 0) {
            return new StringBuilder("0");
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int temp = carry;
            temp += (num.charAt(i) - '0') * x;
            sb.insert(0, temp % 10);
            carry = temp / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb;
    }

    public static String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int length = Math.max(num1.length(), num2.length());
        int carry = 0;
        for (int i = 1; i <= length; i++) {
            int temp = carry;
            if (i <= num1.length()) {
                temp += num1.charAt(num1.length() - i) - '0';
            }
            if (i <= num2.length()) {
                temp += num2.charAt(num2.length() - i) - '0';
            }
            sb.insert(0, temp % 10);
            carry = temp / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static String praseZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return s;
            }
        }
        return "0";
    }
}
