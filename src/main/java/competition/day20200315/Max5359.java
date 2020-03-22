package competition.day20200315;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200315
 * @ClassName: Max5359
 * @Author: markey
 * @Description:
 * @Date: 2020/3/15 11:21
 * @Version: 1.0
 */
public class Max5359 {

    public static void main(String[] args) {
        int n = 7;
        int[] speed =      new int[] {1,4,1,9,4,4,4};
        int[] efficiency = new int[] {8,2,1,7,1,8,4};
        int k = 6;
        System.out.println(maxPerformance(n, speed, efficiency, k));
    }
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Map<Integer, List<Integer>> speedMap = new LinkedHashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!speedMap.containsKey(efficiency[i])) {
                speedMap.put(efficiency[i], new ArrayList<>());
            }
            speedMap.get(efficiency[i]).add(speed[i]);
        }
        for (int key: speedMap.keySet()) {
            Collections.sort(speedMap.get(key));
        }
        System.out.println(speedMap);
        List<Integer> efficiencyList = Arrays.stream(efficiency).boxed().sorted((a, b) -> b - a).collect(Collectors.toList());
        System.out.println(efficiencyList);
        //找出第一个最大表现值
        int efficiencyNow = efficiencyList.get(0);

        List<Integer> speedList = new ArrayList<>();
        long speedNow = addValue(speedList, getMaxValue(speedMap, efficiencyNow), k);
        long performanceNow = speedNow * efficiencyNow;
        long max = performanceNow;
        /**
         * 遍历剩下的efficiencyList
         * 每次加入都会令efficiency变小，所以要取出除当前节点外的其他最大的n个speed
         */
        for (int i = 1; i < n; i++) {
            efficiencyNow = efficiencyList.get(i);
            speedNow = addValue(speedList, getMaxValue(speedMap, efficiencyNow), k);
            System.out.println(speedList + "speedNow:" + speedNow);
            System.out.println(efficiencyNow);
            performanceNow = efficiencyNow * speedNow;
            max = Math.max(max, performanceNow);
        }

        return (int) (max % 1000000007);
    }

    // 得用小顶堆排序，否则会超时
    private static long addValue(List<Integer> list, int value, int k) {
        list.add(value);
        list.sort((a, b) -> b -a);
        if (k > list.size()) k = list.size();
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += list.get(i);
        }
        if (list.get(k - 1) > value) {
            sum += value;
        } else {
            sum += list.get(k - 1);
        }
        return sum;
    }

    private static int getMaxValue(Map<Integer, List<Integer>> speedMap, int key) {
        List<Integer> list = speedMap.get(key);
        return list.remove(list.size() - 1);
    }
}
