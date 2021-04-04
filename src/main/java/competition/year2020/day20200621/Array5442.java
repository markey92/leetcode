package competition.year2020.day20200621;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200621
 * @ClassName: Array5442
 * @Author: markey
 * @Description:
 * @Date: 2020/6/21 10:53
 * @Version: 1.0
 */
public class Array5442 {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Map<Integer, Integer> lakes = new HashMap(); // 表示第n个湖是否是满的
        List<Integer> zeroIndex = new ArrayList<>();
        for (int i = 0; i < rains.length; i++) {
            System.out.println(lakes);
            System.out.println(zeroIndex);
            if (rains[i] > 0) {
                if (lakes.containsKey(rains[i])) {
                    if (zeroIndex.size() <= 0) {
                        return new int[]{};
                    } else {
                        for (int j = 0; j < zeroIndex.size(); j++) {
                            if (zeroIndex.get(j) > lakes.get(rains[i])) {
                                res[zeroIndex.remove(j)] = rains[i];
                                lakes.put(rains[i], i);
                            };
                        }
                        if (lakes.get(rains[i]) != i) {
                            return new int[]{};
                        }
                    }
                }
                res[i] = -1;
                lakes.put(rains[i], i);
            } else {
                zeroIndex.add(i);
            }
        }
        for (int i = 0; i < zeroIndex.size(); i++) {
            res[zeroIndex.get(i)] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new int[100000];
        for (int i = 0; i < 100000; i++) {
            res[i] = i + 1;
        }
        System.out.println(Arrays.toString(res));
    }
}
