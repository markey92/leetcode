package competition.year2020.day20200802;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200802
 * @ClassName: Leetcode5476
 * @Author: markey
 * @Description:
 * @Date: 2020/8/2 10:38
 * @Version: 1.0
 */
public class Leetcode5476 {
    public int getWinner(int[] arr, int k) {
        int count = 0;
        List<Integer> list = Arrays.stream(arr).
                boxed().collect(Collectors.toList());
        int max = list.stream().max(Integer::compareTo).get();
        System.out.println(max);
        while (count < k) {
            if (list.get(0) > list.get(1)) {
                count++;
                list.add(list.remove(1));
            } else {
                count = 1;
                list.add(list.remove(0));
            }
            System.out.println(list.get(0));
            if (list.get(0) == max) {
                return max;
            }
        }
        return list.get(0);
    }
}
