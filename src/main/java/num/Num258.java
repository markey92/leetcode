package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num258
 * @Author: markey
 * @Description:
 * @Date: 2020/5/22 23:00
 * @Version: 1.0
 */
public class Num258 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }
        return addDigits(temp);
    }
}
