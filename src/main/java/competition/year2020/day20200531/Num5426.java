package competition.year2020.day20200531;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200531
 * @ClassName: Num5426
 * @Author: markey
 * @Description:
 * @Date: 2020/5/31 10:51
 * @Version: 1.0
 */
public class Num5426 {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Integer> sourceMap = new HashMap<>();
        Map<Integer, Integer> destMap = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            int source = connections[i][0];
            int dest = connections[i][1];
            sourceMap.put(source, dest);
            destMap.put(dest, source);
        }
        System.out.println(sourceMap);
        System.out.println(destMap);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return tranDirctor(set, sourceMap, destMap, 0);
    }

    private int tranDirctor(Set<Integer> set, Map<Integer, Integer> sourceMap, Map<Integer, Integer> destMap, int target) {
        int count = 0;
        set.add(target);
        if (destMap.containsKey(target)) {
            int temp = destMap.remove(target);
            count += tranDirctor(set, sourceMap, destMap, temp);
        }
        if (sourceMap.containsKey(target)) {
            count++;
            System.out.println(sourceMap.get(target) + "->" + target);
            int temp = sourceMap.remove(target);
            if (!set.contains(temp)) {
                count += tranDirctor(set, sourceMap, destMap, temp);
            }
        }
        return count;
    }
}
