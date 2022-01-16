package competition.year2021.day20211219;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211219
 * @ClassName: Leetcode5957
 * @Author: markey
 * @Description:
 * @Date: 2021/12/19 10:33
 * @Version: 1.0
 */
public class Leetcode5957 {
    public String addSpaces(String s, int[] spaces) {
        int nextEmptyIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (nextEmptyIndex < spaces.length && i == spaces[nextEmptyIndex]) {
                stringBuilder.append(' ');
                nextEmptyIndex++;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
