package competition.year2020.day20201226;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201226
 * @ClassName: Leetcode5622
 * @Author: markey
 * @Description:
 * @Date: 2020/12/26 22:39
 * @Version: 1.0
 */
public class Leetcode5622 {
    public double averageWaitingTime(int[][] customers) {
        int cook = 0;
        double wait = 0;
        for (int i = 0; i < customers.length; i++) {
            int arrivedTime = customers[i][0];
            int needTime = customers[i][1];
            if (arrivedTime < cook) {
                wait += cook - arrivedTime;
//                System.out.println(wait);
            }
            wait += needTime;
            cook = Math.max(arrivedTime, cook) + needTime;
        }
        return wait / customers.length;
    }
}
