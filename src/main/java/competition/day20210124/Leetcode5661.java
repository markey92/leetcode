package competition.day20210124;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210124
 * @ClassName: Leetcode5661
 * @Author: markey
 * @Description:
 * @Date: 2021/1/24 10:30
 * @Version: 1.0
 */
public class Leetcode5661 {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != '?') {
                sb.append(time.charAt(i));
                continue;
            }
            if (i == 0) {
                if (time.charAt(1) >= '4' && time.charAt(1) != '?') {
                    sb.append('1');
                } else {
                    sb.append('2');
                }
            } else if (i == 1) {
                if (sb.charAt(0) == '2') {
                    sb.append('3');
                } else {
                    sb.append('9');
                }
            } else if (i == 3) {
                sb.append('5');
            } else if (i == 4) {
                sb.append('9');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}
