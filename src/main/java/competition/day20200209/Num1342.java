package competition.day20200209;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200209
 * @ClassName: Num1342
 * @Author: markey
 * @Description:
 * @Date: 2020/3/11 22:34
 * @Version: 1.0
 */
public class Num1342 {
    public int numberOfSteps (int num) {
        int n = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            n++;
        }
        return n;
    }
}
