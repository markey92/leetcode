package stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack392
 * @Author: markey
 * @Description:
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢:
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1 21:09
 * @Version: 1.0
 */
public class Stack392 {
    /**
     * 执行用时 :349 ms, 在所有 java 提交中击败了6.86%的用户
     * 内存消耗 :128.7 MB, 在所有 java 提交中击败了5.00%的用户
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            dp[0][i] = s.charAt(0) == t.charAt(i) || dp[0][i-1];
        }

        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()-1][t.length()-1];
    }
    /**
     * Runtime: 17 ms, faster than 46.85% of Java online submissions for Is Subsequence.
     * Memory Usage: 48.2 MB, less than 100.00% of Java online submissions for Is Subsequence.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0, tIndex;
        for (tIndex = 0; sIndex < s.length() && tIndex < t.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex ++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }
}
