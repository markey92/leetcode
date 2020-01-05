package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: backtracking
 * @ClassName: BackTracking784
 * @Author: markey
 * @Description:
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:36
 * @Version: 1.0
 */
public class BackTracking784 {
    /**
     * Runtime: 5 ms, faster than 31.69% of Java online submissions for Letter Case Permutation.
     * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Letter Case Permutation.
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder());
        for (char s: S.toCharArray()) {
            int n = res.size();
            if (Character.isLetter(s)) {
                for (int i = 0; i < n; i++) {
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(s));
                    res.get(i + n).append(Character.toUpperCase(s));
                }
            } else {
                for (StringBuilder sb: res) {
                    sb.append(s);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb: res) {
            result.add(sb.toString());
        }
        return result;
    }
}
