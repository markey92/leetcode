package competition.day20210403;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210403
 * @ClassName: Leetcode5705
 * @Author: markey
 * @Description:
 * @Date: 2021/4/3 22:31
 * @Version: 1.0
 */
public class Leetcode5705 {
    public boolean squareIsWhite(String coordinates) {
        char first= coordinates.charAt(0);
        char second = coordinates.charAt(1);
        if ((first - 'a') % 2 == 0) {
            return (second - '1') % 2 != 0;
        } else {
            return (second - '1') % 2 == 0;
        }
    }
}
