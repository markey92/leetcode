package competition.year2020.day20200530;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200530
 * @ClassName: Tree5410
 * @Author: markey
 * @Description:
 * @Date: 2020/5/30 22:46
 * @Version: 1.0
 */
public class Tree5410 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][0];
            int tail = prerequisites[i][1];
            if (!map.containsKey(tail)) {
                map.put(tail, new HashSet<>());
            }
            map.get(tail).add(pre);
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int pre = queries[i][0];
            int tail = queries[i][1];
            if (!map.containsKey(tail)) {
                res.add(false);
                continue;
            }
            if (map.get(tail).contains(pre)) {
                res.add(true);
                continue;
            }
            Set<Integer> temp;
            int size = 0;
            do {
                temp = new HashSet<>();
                size = map.get(tail).size();
                Iterator<Integer> iterator = map.get(tail).iterator();
                while (iterator.hasNext()) {
                    int x = iterator.next();
                    if (map.containsKey(x)) {
                        temp.addAll(map.get(x));
                    }
                }
                if (temp.contains(pre)) {
                    res.add(true);
                    break;
                }
                map.get(tail).addAll(temp);
            } while (map.get(tail).size() > size);
            if (res.size() != i + 1) {
                res.add(false);
            }
        }
        System.out.println(map);
        return res;
    }
}
