package competition.year2020.day20201025;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201025
 * @ClassName: Leetcode5543
 * @Author: markey
 * @Description:
 * @Date: 2020/10/25 10:31
 * @Version: 1.0
 */
public class Leetcode5546 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = 0;
        int lastTime = 0;
        char res = ' ';
        int n = keysPressed.length();
        for (int i = 0; i < n; i++) {
            int time = releaseTimes[i] - lastTime;
            lastTime = releaseTimes[i];
            if (time > max) {
                res = keysPressed.charAt(i);
                max = time;
            } else if (time == max) {
                res = (char) Math.max(res, keysPressed.charAt(i));
            }
        }
        return res;
    }
}
