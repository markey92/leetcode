package competition.day20211212;

import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211212
 * @ClassName: Leetcode5955
 * @Author: markey
 * @Description:
 * @Date: 2021/12/12 10:52
 * @Version: 1.0
 */
public class Leetcode5955 {
    public static void main(String[] args) {
        Leetcode5955 leetcode5955 = new Leetcode5955();
        leetcode5955.maxTotalFruits(new int[][] {{2, 100000}}, 0, 2);
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        TreeMap<Integer, Integer> preSum = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < fruits.length; i++) {
            sum += fruits[i][1];
            preSum.put(fruits[i][0], sum);
        }
        int max = 0;
        // 枚举先向左走了i步
        for (int i = 0; i <= Math.min(k, startPos); i++) {
            int count = 0;
            // 左边收获的果子
            Integer leftStart = preSum.lowerKey(startPos - i);
            Integer leftEnd = preSum.floorKey(startPos);
            if (leftEnd == null) {
                // 左边没有果子
                break;
            } else if (leftStart == null) {
                count += preSum.get(leftEnd);
            } else {
                count += preSum.get(leftEnd) - preSum.get(leftStart);
            }
            if (k > i * 2) {
                // 右边收获的果子
                Integer rightEnd = preSum.floorKey(startPos + k - i * 2);
                count += preSum.get(rightEnd) - preSum.get(leftEnd);
            }
            max = Math.max(max, count);
        }

        // 枚举先向左走了i步
        for (int i = 0; i <= k; i++) {
            int count = 0;
            // 右边收获的果子
            Integer rightEnd = preSum.floorKey(startPos + i);
            Integer leftEnd = preSum.lowerKey(startPos);
            if (rightEnd == null || rightEnd < startPos) {
                // 右边没有果子
                continue;
            } else if (leftEnd == null) {
                // 左边没有果子
                count += preSum.get(rightEnd);
            } else {
                count += preSum.get(rightEnd) - preSum.get(leftEnd);
            }
            if (k > i * 2) {
                // 右边收获的果子
                Integer leftStart = preSum.lowerKey(startPos - (k - i * 2));
                if (leftStart == null) {
                    if (leftEnd != null) {
                        count += preSum.get(leftEnd);
                    }
                } else {
                    count += preSum.get(leftEnd) - preSum.get(leftStart);
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
