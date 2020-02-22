package competition.day20200222;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200222
 * @ClassName: Num5325
 * @Author: markey
 * @Description:5325. 包含所有三种字符的子字符串数目
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 *
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：1
 *
 *
 * 提示：
 *
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 * @Date: 2020/2/22 23:23
 * @Version: 1.0
 */
public class Num5325 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
    public static int numberOfSubstrings(String s) {
        int num = 0;
        int numA = 0, numB = 0, numC = 0;
        int start = 0, end = 0;
        while (end < s.length() && start < s.length() - 2) {
            if (s.charAt(end) == 'a') {
                numA++;
            } else if (s.charAt(end) == 'b') {
                numB++;
            } else {
                numC++;
            }
            System.out.println("wai" + numA + " " + numB + " " + numC);
            while (numA > 0 && numB > 0 && numC > 0) {
                num += s.length() - end;
                System.out.println("num " + num);
                if (s.charAt(start) == 'a') {
                    numA--;
                } else if (s.charAt(start) == 'b') {
                    numB--;
                } else {
                    numC--;
                }
                start++;
                System.out.println("li" + numA + " " + numB + " " + numC);
            }
            end++;

        }
        return num;
    }
}
