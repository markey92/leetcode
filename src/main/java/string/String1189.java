package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String1189
 * @Author: markey
 * @Description:
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/8 22:37
 * @Version: 1.0
 */
public class String1189 {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String balloon = "balloon";
        int min = Integer.MAX_VALUE;
        for (char c: balloon.toCharArray()) {
            if (c == 'l' || c == 'o') {
                if (map.getOrDefault(c, 0) / 2 < min) {
                    min = map.getOrDefault(c, 0) / 2;
                }
            } else {
                if (map.getOrDefault(c, 0) < min) {
                    min = map.getOrDefault(c, 0);
                }
            }
        }
        return min;
    }
}
