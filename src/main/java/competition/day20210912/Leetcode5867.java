package competition.day20210912;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210912
 * @ClassName: Leetcode5867
 * @Author: markey
 * @Description:
 * @Date: 2021/9/12 10:30
 * @Version: 1.0
 */
public class Leetcode5867 {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder(word);
        while (j < i) {
            char tmp = stringBuilder.charAt(j);
            stringBuilder.setCharAt(j, stringBuilder.charAt(i));
            stringBuilder.setCharAt(i, tmp);
            i--;
            j++;
        }
        return stringBuilder.toString();
    }
}
