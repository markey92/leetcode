package competition.year2020.day20200322;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200322
 * @ClassName: String5367
 * @Author: markey
 * @Description:5367. 最长快乐前缀
 * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
 *
 * 给你一个字符串 s，请你返回它的 最长快乐前缀。
 *
 * 如果不存在满足题意的前缀，则返回一个空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "level"
 * 输出："l"
 * 解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", "evel"）。最长的既是前缀也是后缀的字符串是 "l" 。
 * 示例 2：
 *
 * 输入：s = "ababab"
 * 输出："abab"
 * 解释："abab" 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
 * 示例 3：
 *
 * 输入：s = "leetcodeleet"
 * 输出："leet"
 * 示例 4：
 *
 * 输入：s = "a"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-happy-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/22 16:47
 * @Version: 1.0
 */
public class String5367 {
    public String longestPrefix(String s) {
        int i = s.length();
        while (i > 0) {
            if (s.substring(0, i).equals(s.substring(s.length() - i))) {
                break;
            } else {
                i--;
            }
        }
        return s.substring(0, i - 1);
    }
}
