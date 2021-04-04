package competition.year2020.day20200816;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200816
 * @ClassName: Leetcode5185
 * @Author: markey
 * @Description:
 * @Date: 2020/8/16 10:30
 * @Version: 1.0
 */
public class Leetcode5185 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
