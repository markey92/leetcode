package array;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array345
 * @Author: markey
 * @Description:
 * @Date: 2020/2/8 17:32
 * @Version: 1.0
 */
public class Array345 {
    public String reverseVowels(String s) {
        char[] list =s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isOrigin(s.charAt(i))) {
                i++;
            }
            while (i < j && !isOrigin(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                list[i] = s.charAt(j);
                list[j] = s.charAt(i);
                i++;
                j--;
            } else {
                break;
            }
        }
        return String.valueOf(list);
    }

    private boolean isOrigin(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
