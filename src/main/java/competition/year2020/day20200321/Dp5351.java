package competition.year2020.day20200321;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200321
 * @ClassName: Dp5351
 * @Author: markey
 * @Description:
 * @Date: 2020/3/21 23:33
 * @Version: 1.0
 */
public class Dp5351 {
    public int maxSizeSlices(int[] slices) {
        int max = 0;

        return maxSizeSlices(Arrays.stream(slices).boxed().collect(Collectors.toList()));
    }

    public int maxSizeSlices(List<Integer> list) {
        if (list.size() == 3) {
            return Math.max(Math.max(list.get(0), list.get(1)), list.get(2));
        }

        int max = 0;
        max = maxSizeSlices(list.subList(3, list.size())) + list.get(1);

        List<Integer> temp = list.subList(2, list.size() - 1);
        max = Math.max(max, maxSizeSlices(temp) + list.get(0));

        temp = list.subList(1, list.size() - 2);
        temp.add(list.get(0));
        max = Math.max(max, maxSizeSlices(temp) + list.get(2));

        return max;
    }
}
