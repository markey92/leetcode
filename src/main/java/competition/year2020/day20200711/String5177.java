package competition.year2020.day20200711;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200711
 * @ClassName: String5177
 * @Author: markey
 * @Description:
 * @Date: 2020/7/11 22:30
 * @Version: 1.0
 */
public class String5177 {
    public String reformatDate(String date) {
        String[] monthList = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] list = date.split(" ");
        String day = list[0].substring(0, list[0].length() - 2); // 去掉后两位
        if (day.length() < 2) day = '0' + day;
        int monthInt = Arrays.asList(monthList).indexOf(list[1]) + 1;
        String month = String.valueOf(monthInt);
        if(monthInt < 10) month = '0' + month;
        return list[2] + '-' + month + '-' + day;
    }
}
