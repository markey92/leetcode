package competition.year2020.day20200912;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200912
 * @ClassName: Test1
 * @Author: markey
 * @Description:
 * @Date: 2020/9/12 15:00
 * @Version: 1.0
 */
public class Test1 {
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (char z : s.toCharArray()) {
            if (z == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }
}
