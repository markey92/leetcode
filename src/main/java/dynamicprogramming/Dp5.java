package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp5
 * @Author: markey
 * @Description:5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/20 23:24
 * @Version: 1.0
 */
public class Dp5 {
    public String longestPalindrome(String s) {
        /**
         * 二维DP表，dp[i,j] 表示s.substring(i,j)是否是回文字母串
         * 则dp[i,j] = dp[i+1,j-1] && s.charat(i) == s.charat(j)
         */
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < 1; i++) {
            
        }
        return "";
    }
}
