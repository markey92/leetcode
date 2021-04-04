package competition.day20210131;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210131
 * @ClassName: Leetcode5665
 * @Author: markey
 * @Description:
 * @Date: 2021/1/31 10:39
 * @Version: 1.0
 */
public class Leetcode5665 {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int[] adjacentPair = adjacentPairs[i];
            if (left.contains(adjacentPair[0])) {
                int temp = adjacentPair[0];
                adjacentPair[0] = adjacentPair[1];
                adjacentPair[1] = temp;
            }
            left.add(adjacentPair[0]);
            right.add(adjacentPair[1]);
        }

        Arrays.sort(adjacentPairs, Comparator.comparingInt(o -> o[0]));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] adjacentPair = adjacentPairs[i];
            if (!res.contains(adjacentPair[0])) {
                res.add(adjacentPair[0]);
            }
            res.add(adjacentPair[1]);
            System.out.println(Arrays.toString(adjacentPair));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
