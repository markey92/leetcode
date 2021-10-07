package competition.year2021.day20210306;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210306
 * @ClassName: Leetcode5681
 * @Author: markey
 * @Description:
 * @Date: 2021/3/6 22:34
 * @Version: 1.0
 */
public class Leetcode5681 {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            } else  if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 3 == 1) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return false;
    }
}
