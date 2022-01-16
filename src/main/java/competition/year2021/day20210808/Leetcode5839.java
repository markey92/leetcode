package competition.year2021.day20210808;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210808
 * @ClassName: Leetcode5839
 * @Author: markey
 * @Description:
 * @Date: 2021/8/8 10:33
 * @Version: 1.0
 */
public class Leetcode5839 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> treeSet = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            treeSet.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int x = treeSet.poll();
            treeSet.add(x - x / 2);
        }
        System.out.println(treeSet);
        return treeSet.stream().mapToInt(Integer::intValue).sum();
    }
}
