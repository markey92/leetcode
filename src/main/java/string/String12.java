package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String12
 * @Author: markey
 * @Description:12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/1 23:28
 * @Version: 1.0
 */
public class String12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int time = 0;

        time = num / 1000;
        for (int i = 0; i < time; i++) {
            sb.append('M');
        }
        num %= 1000;

        if (num >= 900) {
            sb.append("CM");
            num -= 900;
        } else {
            time = num / 500;
            for (int i = 0; i < time; i++) {
                sb.append('D');
            }
            num %= 500;
        }


        time = num / 100;
        if (time == 4) {
            sb.append("CD");
        } else {
            for (int i = 0; i < time; i++) {
                sb.append('C');
            }
        }
        num %= 100;

        if (num >= 90) {
            sb.append("XC");
            num -= 90;
        } else {
            time = num / 50;
            for (int i = 0; i < time; i++) {
                sb.append('L');
            }
            num %= 50;
        }

        time = num / 10;
        if (time == 4) {
            sb.append("XL");
        } else {
            for (int i = 0; i < time; i++) {
                sb.append('X');
            }
        }
        num %= 10;

        if (num >= 9) {
            sb.append("IX");
            num -= 9;
        } else {
            time = num / 5;
            for (int i = 0; i < time; i++) {
                sb.append('V');
            }
            num %= 5;
        }

        time = num / 1;
        if (time == 4) {
            sb.append("IV");
        } else {
            for (int i = 0; i < time; i++) {
                sb.append('I');
            }
        }

        return sb.toString();
    }
}
