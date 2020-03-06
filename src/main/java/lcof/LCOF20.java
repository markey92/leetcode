package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF20
 * @Author: markey
 * @Description:面试题20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/4 0:00
 * @Version: 1.0
 */
public class LCOF20 {
    // 就是各种情况的处理
    // 别做这道题，各种数字特别无语
    // .3  3. -.3e3 都算数字
    public boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        while (s.charAt(0) == ' ') {
            if (s.length() == 1) {
                return false;
            }
            s = s.substring(1);
        }
        while (s.charAt(s.length() - 1) == ' ') {
            if (s.length() == 1) {
                return false;
            }
            s = s.substring(0, s.length() - 1);
        }
        return isSignedInt(s) || isSignedDouble(s) || isE(s);

    }

    private boolean isE(String s) {
        if (s.length() > 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            return isE(s.substring(1));
        }
        int eNum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'e' || c == 'E') {
                eNum ++;
            }
        }
        if (eNum != 1) {
            return false;
        }
        String[] array = s.split("e|E");
        if (array.length != 2) {
            return false;
        }
        System.out.println(array[0] + " " + array[1]);
        return (isSignedInt(array[0]) || isDouble(array[0])) && isSignedInt(array[1]);
    }

    private boolean isSignedIntOrEmpty(String s) {
        if (s.length() == 0) {
            return true;
        }
        return isSignedInt(s);
    }

    private boolean isSignedInt(String s) {
        if (s.length() > 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            return isInt(s.substring(1));
        }
        return isInt(s);
    }

    private boolean isInt(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isSignedDouble(String s) {
        if (s.length() > 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            return isDouble(s.substring(1)) || isDouble(s.substring(1));
        }
        return isDouble(s);
    }

    private boolean isDouble(String s) {
        int pointNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '.') {
                pointNum ++;
            }
        }
        if (pointNum != 1) {
            return false;
        }
        if (s.length() < 2) {
            return false;
        }
        String[] array = s.split("\\.");
        if (array.length == 0 || array.length > 2) {
            return false;
        }
        if (array.length == 1) {
            System.out.println(array[0]);
            return s.charAt(0) == '.' ? isInt(array[0]) : isSignedIntOrEmpty(array[0]);
        }
        return isSignedIntOrEmpty(array[0]) && isInt(array[1]);
    }
}
