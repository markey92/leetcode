package competition.year2020.day20200809;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200809
 * @ClassName: Leetcode5486
 * @Author: markey
 * @Description:
 * @Date: 2020/8/9 11:48
 * @Version: 1.0
 */
public class Leetcode5486 {
    public int minCost(int n, int[] cuts) {
        return minCost(0, n, Arrays.stream(cuts).boxed().sorted().collect(Collectors.toList()));
    }

    public int minCost(int start, int end, List<Integer> cuts) {
        System.out.println(start + " " + end + " " + cuts);
        if (cuts.size() == 0) {
            return 0;
        }
        if (cuts.size() == 1) {
            System.out.println(cuts.get(0));
            return end - start;
        }
        if (cuts.size() % 2 == 1) {
            System.out.println(cuts.size());
            int middle = cuts.size() / 2 + 1;
            return end - start
                    + minCost(start, cuts.get(middle), cuts.subList(0, middle))
                    + minCost(cuts.get(middle), end, cuts.subList(middle + 1, cuts.size()));
        } else {
            int left = cuts.size() / 2;
            int sumLeft = minCost(start, cuts.get(left), cuts.subList(0, left))
                    + minCost(cuts.get(left), end, cuts.subList(left + 1, cuts.size()));
            int right = cuts.size() / 2 + 1;
            int sumRight = minCost(start, cuts.get(right), cuts.subList(0, right))
                    + minCost(cuts.get(right), end, cuts.subList(right + 1, cuts.size()));
            return end - start + Math.min(sumLeft, sumRight);
        }
    }
}
