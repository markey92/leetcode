package string;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String5
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
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/1 17:23
 * @Version: 1.0
 */
public class String5 {
    public static void main(String[] args) {
        String res = longestPalindrome("cbbd");
        System.out.println(res);
    }

    /**
     * 动态规划 dp[i][j]表示s.substring(j,i+1)是否是回文字符串，
     * 则dp[i][j] = dp[i-1][j+1] && s.charAt(j) == s.charAt(i)
     *
     */

    public static String longestPalindrome(String s) {
        String res = "";
        int[][] dp = new int[s.length()][s.length()]; // 所有可能是字符串集合,1表示回文，0表示不回文
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res; // 取最长回文子串
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 > i - 1) {
                        // 这种情况其实i和j相邻了，想想i和j相邻，并且他们字符一样，那肯定是长度位2的回文子串
                        dp[i][j] = 1;
                        res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res; // 取最长回文子串
                        continue;
                    }
                    if (dp[i-1][j+1] == 1) {
                        dp[i][j] = 1;
                        res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res; // 取最长回文子串
                        continue;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }
}
