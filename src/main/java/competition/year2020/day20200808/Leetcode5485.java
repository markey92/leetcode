package competition.year2020.day20200808;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200808
 * @ClassName: Leetcode5485
 * @Author: markey
 * @Description:
 * @Date: 2020/8/9 0:04
 * @Version: 1.0
 */
public class Leetcode5485 {
    // 先用二维dp，然后可以简化为一维dp 一维dp任然超时
    // 正确解法用前缀和
    public int longestAwesome(String s) {
        int max = 1;
        int n = s.length();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int status = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            status = status ^ (1 << num); // 用二进制数来表示某一个个数字出现次数是否是奇数
            // System.out.println(Integer.toBinaryString(status));
            if (status == 0) {
                // 所有数字都出现偶数次
                max = Math.max(max, i + 1);
                continue;
            }
            if (firstIndex.containsKey(status)) {
                // 有相同状态出现过，可以令的每个数字出现次数都为偶数次
                max = Math.max(max, i - firstIndex.get(status));
            } else {
                firstIndex.put(status, i);
            }
            for (int j = 0; j < 10; j++) {
                int temp = status ^ (1 << j);
                if (temp == 0) {
                    // 只有一位数字出现奇数次
                    max = Math.max(max, i + 1);
                    break;
                }
                if (firstIndex.containsKey(temp)) {
                    // 有只相差一位的状态出现过
                    max = Math.max(max, i - firstIndex.get(temp));
                }
            }
        }
        return max;
    }
}
