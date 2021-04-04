package competition.year2020.day20200209;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200209
 * @ClassName: Num1344
 * @Author: markey
 * @Description:1344. 时钟指针的夹角
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * 示例 1：
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * @Date: 2020/3/11 22:48
 * @Version: 1.0
 */
public class Num1344 {
    public double angleClock(int hour, int minutes) {
        double angleHour = 30 * hour + 6.0 * minutes / 12;
        double angleMinutes = 6.0 * minutes;
        System.out.println(angleHour);
        System.out.println(angleMinutes);
        double res = Math.abs(angleHour - angleMinutes);
        return res > 180 ? (360 - res): res;
    }
}
