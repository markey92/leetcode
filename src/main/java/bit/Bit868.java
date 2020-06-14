package bit;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: Bit868
 * @Author: markey
 * @Description:
 * @Date: 2020/6/4 23:12
 * @Version: 1.0
 */
public class Bit868 {
    public int binaryGap(int N) {
        int max = 0;
        int index = 0;
        int lastIndex = Integer.MAX_VALUE;
        while ((N = N>>1) > 0) {
            index++;
            if ((N & 1) == 1) {
                max = Math.max(max, index - lastIndex);
                lastIndex = index;
            }
        }
        return max;
    }
}
