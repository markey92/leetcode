package competition.year2020.day20201206;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201206
 * @ClassName: Leetcode5617
 * @Author: markey
 * @Description:
 * @Date: 2020/12/6 10:31
 * @Version: 1.0
 */
public class Leetcode5617 {
    public String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                stringBuilder.append("G");
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                stringBuilder.append("al");
                i += 3;
            } else {
                stringBuilder.append("o");
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
