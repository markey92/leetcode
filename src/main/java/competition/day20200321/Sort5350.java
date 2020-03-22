package competition.day20200321;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200321
 * @ClassName: Sort5350
 * @Author: markey
 * @Description:
 * @Date: 2020/3/21 22:38
 * @Version: 1.0
 */
public class Sort5350 {
    public static void main(String[] args) {
        System.out.println(getKth(12, 15, 2));
    }
    public static int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] array = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            weight(i, map);
            array[i - lo] = i;
        }
        System.out.println(map);
        array = Arrays.stream(array).boxed().sorted((a,b) -> {return map.get(a) == map.get(b) ? a - b : map.get(a) - map.get(b);}).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array));
        return array[k - 1];
    }

    private static void weight(int x, Map<Integer, Integer> map) {
        int temp = x;
        int weight = 0;
        while (x != 1) {
            if (map.containsKey(x)) {
                weight += map.get(x);
                break;
            }
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
            }
            weight++;
        }
        map.put(temp, weight);
    }
}
