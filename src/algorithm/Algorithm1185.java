package algorithm;

/**
 * @ProjectName: leetcode
 * @Package: algorithm
 * @ClassName: Algorithm1185
 * @Author: markey
 * @Description:
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 22:15
 * @Version: 1.0
 */
public class Algorithm1185 {
    public String dayOfTheWeek(int day, int month, int year) {

        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;

        String weekstr = "";
        switch (week) {
            case 0:
                weekstr = "Monday";
                break;
            case 1:
                weekstr = "Tuesday";
                break;
            case 2:
                weekstr = "Wednesday";
                break;
            case 3:
                weekstr = "Thursday";
                break;
            case 4:
                weekstr = "Friday";
                break;
            case 5:
                weekstr = "Saturday";
                break;
            case 6:
                weekstr = "Sunday";
                break;
        }
        return weekstr;
    }
}
