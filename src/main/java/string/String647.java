package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String647
 * @Author: markey
 * @Description:647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/23 22:00
 * @Version: 1.0
 */
public class String647 {
    // 动态规划法
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 只需要半个矩阵即可
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
                    continue;
                }
                dp[i][j] = (dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)) ? 1 : 0;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }

    // 分治法
    public int countSubstrings1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countSubStrings(s, i, i);
            count += countSubStrings(s, i, i+1);
        }
        return count;
    }

    private int countSubStrings(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
