package competition.year2020.day20200627;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200627
 * @ClassName: Array5432
 * @Author: markey
 * @Description:
 * @Date: 2020/6/27 22:30
 * @Version: 1.0
 */
public class Array5432 {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            sum += salary[i];
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
