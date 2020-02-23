package competition.day20200223;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200223
 * @ClassName: Num5129
 * @Author: markey
 * @Description:日期之间隔几天
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 *
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * 示例 1：
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * 示例 2：
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 * 提示：
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 * @Date: 2020/2/23 10:30
 * @Version: 1.0
 */
public class Num5169 {
    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int res = 0;
        try {
            Date start = sdf.parse(date1), end = sdf.parse(date2);
            res = (int) ((end.getTime() - start.getTime()) / (3600 * 24 * 1000));
            res = res < 0 ? 0 - res : res;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }
}
