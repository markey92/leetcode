package competition.year2021.day20210620;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210620
 * @ClassName: Leetcode5789
 * @Author: markey
 * @Description:
 * @Date: 2021/6/20 10:35
 * @Version: 1.0
 */
public class Leetcode5789 {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = getStartTime(startTime);
        int end = getEndTime(finishTime);
        if (start > end) {
            return numberOfRounds("00:00", finishTime) + numberOfRounds(startTime, "24:00");
        } else {
            return end - start;
        }
    }
    private int getStartTime(String time) {
        String[] hourAndMin = time.split(":");
        int res = 0;
        res += 4 * Integer.valueOf(hourAndMin[0]);
        int min = Integer.valueOf(hourAndMin[1]);
        res += min / 15;
        if (min % 15 > 0) {
            res += 1;
        }
        return res;
    }
    private int getEndTime(String time) {
        String[] hourAndMin = time.split(":");
        int res = 0;
        res += 4 * Integer.valueOf(hourAndMin[0]);
        int min = Integer.valueOf(hourAndMin[1]);
        res += min / 15;
        return res;
    }
}
