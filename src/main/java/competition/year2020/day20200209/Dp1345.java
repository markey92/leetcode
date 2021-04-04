package competition.year2020.day20200209;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200209
 * @ClassName: Dp1345
 * @Author: markey
 * @Description:1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 * 示例 1：
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 *
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * @Date: 2020/3/11 23:03
 * @Version: 1.0
 */
public class Dp1345 {

    // 还得得用队列，每个位置的值改变时，其前后都有可能改变
    public int minJumps(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length];
        Map<Integer, Integer> minMap = new HashMap<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
            minMap.put(arr[i], Math.min(i, minMap.getOrDefault(arr[i], Integer.MAX_VALUE)));
            queue.add(i);
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], new ArrayList<Integer>());
            }
            // 这个map主要是用来记录同一值的位置的，如果是连续的，只需要直到首尾即可，其他没有意义
            if (indexMap.get(arr[i]).size() == 0 && indexMap.get(arr[i]).get(indexMap.get(arr[i]).size() - 1) == (i -1)) {
                indexMap.get(arr[i]).remove(indexMap.get(arr[i]).size() - 1);
            }
            indexMap.get(arr[i]).add(i);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int min = res[x];
            if (x < res.length - 1 && min > res[x + 1] + 1) {
                min = res[x + 1] + 1;
            }
            if (x > 1 && min > res[x - 1] + 1) {
                min = res[x - 1] + 1;
            }
            min = Math.min(min, minMap.get(arr[x]) + 1);

            if (res[x] > min) {
                res[x] = min;
                if ((x + 1) < res.length) {
                    queue.add(x + 1);
                }
                if ((x - 1) > 0) {
                    queue.add(x - 1);
                }
                for (int i = 0; i < indexMap.get(arr[x]).size(); i++) {
                    if (indexMap.get(arr[x]).get(i) != x) {
                        queue.add(indexMap.get(arr[x]).get(i));
                    }
                }
            }
            if (minMap.get(arr[x]) > res[x]) {
                minMap.put(arr[x], res[x]);
            }
        }
        return res[res.length - 1];
    }
}
