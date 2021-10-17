package competition.year2021.day20210801;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210801
 * @ClassName: Leetcode5831
 * @Author: markey
 * @Description:
 * @Date: 2021/8/1 10:39
 * @Version: 1.0
 */
public class Leetcode5831 {
    public static void main(String[] args) {
        Leetcode5831 leetcode5831 = new Leetcode5831();
        System.out.println(leetcode5831.numberOfWeeks(new int[] {8,8,2,6}));
    }
    public long numberOfWeeks(int[] milestones) {
        long max = Arrays.stream(milestones).max().getAsInt();
        long sum = Arrays.stream(milestones)
                .mapToLong(Long::valueOf).sum();
        return Math.min(sum, (sum - max) * 2L + 1);
    }
}
