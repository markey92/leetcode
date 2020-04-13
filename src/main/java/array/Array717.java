package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array717
 * @Author: markey
 * @Description:
 * @Date: 2020/4/7 23:17
 * @Version: 1.0
 */
public class Array717 {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (i == bits.length - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return false;
    }
}
