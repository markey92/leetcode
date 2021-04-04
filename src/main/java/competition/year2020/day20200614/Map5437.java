package competition.year2020.day20200614;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200614
 * @ClassName: Map5437
 * @Author: markey
 * @Description:
 * @Date: 2020/6/14 10:33
 * @Version: 1.0
 */
public class Map5437 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        System.out.println(list);
        int count = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext() && count < k) {
            count += iterator.next();
            iterator.remove();
        }
        return count > k ? list.size() + 1 : list.size();
    }
}
