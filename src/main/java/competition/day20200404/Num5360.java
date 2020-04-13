package competition.day20200404;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200404
 * @ClassName: Num5360
 * @Author: markey
 * @Description:5360. 统计最大组的数目 显示英文描述
 * 用户通过次数0
 * 用户尝试次数0
 * 通过次数0
 * 提交次数0
 * 题目难度Easy
 * 给你一个整数 n 。请你先将从 1 到 n 的所有整数按 10 进制对各个数位求和，然后把数位和相等的数字放到同一个组中。
 *
 * 请你统计每个组的数字数目，并返回数字数目并列最多的组有多少个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：4
 * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
 * 示例 3：
 *
 * 输入：n = 15
 * 输出：6
 * 示例 4：
 *
 * 输入：n = 24
 * 输出：5
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^4
 * @Date: 2020/4/4 22:32
 * @Version: 1.0
 */
public class Num5360 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = countBit(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        System.out.println(map);

        int res = 0;
        for(int key: map.keySet()) {
            res += map.get(key) == max ? 1:0;
        }
        return res;
    }

    private int countBit(int n) {
        int res = 0;
        while (n != 0) {
            res += n%10;
            n = n/10;
        }
        System.out.println(res);
        return res;
    }
}
