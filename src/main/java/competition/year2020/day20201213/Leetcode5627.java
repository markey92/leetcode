package competition.year2020.day20201213;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201213
 * @ClassName: Leetcode5627
 * @Author: markey
 * @Description:
 * @Date: 2020/12/13 10:41
 * @Version: 1.0
 */
public class Leetcode5627 {
    public int stoneGameVII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int scoreA = 0, scoreB = 0;
        int start = 0, end = stones.length - 1;
        int order = 0;
        while (start <= end) {
            if (order % 2 == 0) {
                if (stones[start] < stones[end]) {
                    sum -= stones[start];
                    start++;
                } else {
                    sum -= stones[end];
                    end--;
                }
                scoreA += sum;

            } else {
                if (stones[start] > stones[end]) {
                    sum -= stones[start];
                    start++;
                } else {
                    sum -= stones[end];
                    end--;
                }
                scoreB += sum;
            }
            System.out.println(scoreA +  " " + scoreB);
            order++;
        }
        return scoreA - scoreB;
    }
    public int stoneGameVII2(int[] stones) {
        int diff = 0;
        int start = 0, end = stones.length - 1;
        while (start < end) {
            if (start == end) {
                start++;
                continue;
            }
            if (end - start == 1) {
                diff += Math.max(stones[start], stones[end]);
                start++;
                end--;
                continue;
            }

            int minStart = Math.min(stones[start + 1], stones[end]);
            int minEnd = Math.min(stones[start], stones[end - 1]);
            System.out.println(minStart + " " + minEnd);
            if (minStart > minEnd) {
                diff += minStart;
                System.out.println("a:" + stones[start]);
                start++;

                if (stones[start + 1] < stones[end]) {
                    System.out.println("b:" + stones[start]);
                    start++;
                } else {
                    System.out.println("b:" + stones[end]);
                    end--;
                }
            } else {
                diff += minEnd;
                System.out.println("a:" + stones[end]);
                end--;
                if (stones[start] < stones[end - 1]) {
                    System.out.println("b:" + stones[start]);
                    start++;
                } else {
                    System.out.println("b:" + stones[end]);
                    end--;
                }
            }
        }
        return diff;
    }
}
