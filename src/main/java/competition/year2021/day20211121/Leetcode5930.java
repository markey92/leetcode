package competition.year2021.day20211121;

/**
 * @ProjectName: leetcode
 * @Package: competition
 * @ClassName: Leetcode5930
 * @Author: markey
 * @Description:
 * @Date: 2021/11/21 10:31
 * @Version: 1.0
 */
public class Leetcode5930 {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < colors.length; i++) {
            for (int j = colors.length - 1; j > i; j--) {
                if (colors[j] != colors[i]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
