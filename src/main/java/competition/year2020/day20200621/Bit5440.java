package competition.year2020.day20200621;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200621
 * @ClassName: Bit5440
 * @Author: markey
 * @Description:
 * @Date: 2020/6/21 10:30
 * @Version: 1.0
 */
public class Bit5440 {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= (start + 2 * i);
        }
        return res;
    }
}
