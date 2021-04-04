package competition.year2020.day20200425;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200425
 * @ClassName: Num3
 * @Author: markey
 * @Description:
 * @Date: 2020/4/25 16:00
 * @Version: 1.0
 */
public class Num3 {
    public static void main(String[] args) {

        int[] time = new int[] {9,8,7,6,5,4};
        int size = 10^5;
        int[] time2 = new int[10^5];
        for (int i = 0; i < size; i++) {
            time2[i] = 10000;
        }
        System.out.println(minTime(time2, 3));
    }
    public static int minTime(int[] time, int m) {
        List<List<Integer>> list = new ArrayList<>();
        int initSize = time.length / m;
        for (int i = 0; i < time.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < initSize; j++) {
                temp.add(time[j]);
            }
            list.add(temp);
        }
        while (list.size() > m) {
            merge(list);
            System.out.println(list);
        }
//        System.out.println(list);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, max(list.get(i)));
        }
        return max;
    }
    private static int max(List<Integer> list) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
            count += list.get(i);
        }
        return count - max;
    }

    private static void merge(List<List<Integer>> list) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < list.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list.get(i));
            temp.addAll(list.get(i + 1));
            int x = max(temp);
            if (x < min) {
                index = i;
                min = x;
            }
        }
        list.get(index).addAll(list.get(index + 1));
        list.remove(index + 1);
    }
}
