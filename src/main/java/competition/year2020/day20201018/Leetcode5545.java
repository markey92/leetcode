package competition.year2020.day20201018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201018
 * @ClassName: Leetcode5545
 * @Author: markey
 * @Description:
 * @Date: 2020/10/18 10:57
 * @Version: 1.0
 */
public class Leetcode5545 {
    public int bestTeamScore(int[] scores, int[] ages) {
        // 初始化索引表
        int n = ages.length;
        int[] indexs = new int[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = i;
        }
        // 按年龄和分数排序，年龄相同时，高年龄排前面，同年龄时，高分数排前面
        indexs = Arrays.stream(indexs).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (ages[o1.intValue()] != ages[o2.intValue()]) {
                    return ages[o2.intValue()] - ages[o1.intValue()];
                } else {
                    return scores[o2.intValue()] - scores[o1.intValue()];
                }
            }
        }).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(indexs));
        int res = scores[indexs[0]];
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {

            if (stack.isEmpty()) {
                System.out.println(ages[indexs[i]] + ":" + scores[indexs[i]]);
            } else {
                System.out.println(ages[stack.peek()] + ":" + scores[stack.peek()] + "->" + ages[indexs[i]] + ":" + scores[indexs[i]]);
            }
            if (stack.isEmpty() || ages[stack.peek()] == ages[indexs[i]] || scores[stack.peek()] >= scores[indexs[i]]) {
                sum += scores[indexs[i]];
                stack.push(indexs[i]);
                res = Math.max(res, sum);
            } else {
                while (!stack.isEmpty() && scores[stack.peek()] < scores[indexs[i]]) {
                    sum -= scores[stack.pop()];
                }
                sum += scores[indexs[i]];
                stack.push(indexs[i]);
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
