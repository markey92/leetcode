package competition.day20200607;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200607
 * @ClassName: Sort5429
 * @Author: markey
 * @Description:
 * @Date: 2020/6/7 10:35
 * @Version: 1.0
 */
public class Sort5429 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int middle = arr[(arr.length - 1) / 2];
        System.out.println(middle);
        int[] sort = Arrays.stream(arr).
                boxed().
                sorted((o1, o2) -> {
                    if (Math.abs(o1 - middle) > Math.abs(o2 - middle)) {
                        return -1;
                    }
                    if ((o1 > o2) && (Math.abs(o1 - middle) == Math.abs(o2 - middle))) {
                        return -1;
                    }
                    return 1;
                }). // sort descending
                mapToInt(i -> i).
                toArray();
        System.out.println(Arrays.toString(sort));
        return Arrays.copyOf(sort, k);
    }
}
