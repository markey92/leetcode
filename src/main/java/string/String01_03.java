package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String01_03
 * @Author: markey
 * @Description:
 * @Date: 2020/5/30 23:54
 * @Version: 1.0
 */
public class String01_03 {
    public String replaceSpaces(String S, int length) {
        char[] array = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (array[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}
