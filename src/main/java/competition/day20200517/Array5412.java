package competition.day20200517;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200517
 * @ClassName: Array5412
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 10:30
 * @Version: 1.0
 */
public class Array5412 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                res++;
            }
        }
        return res;
    }
}
