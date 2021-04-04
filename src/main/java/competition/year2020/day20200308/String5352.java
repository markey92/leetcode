package competition.year2020.day20200308;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200308
 * @ClassName: String5352
 * @Author: markey
 * @Description:
 * @Date: 2020/3/8 10:31
 * @Version: 1.0
 */
public class String5352 {
    public String generateTheString(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "a";
        }
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        } else {
            for (int i = 0; i < n - 2; i++) {
                sb.append("a");
            }
            sb.append("b");
            sb.append("c");
        }
        return sb.toString();
    }
}
