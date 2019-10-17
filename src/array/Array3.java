package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array3
 * @Author: markey
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:35
 * @Version: 1.0
 */
public class Array3 {

    /**
     * 执行用时 :679 ms, 在所有 java 提交中击败了5.01%的用户
     * 内存消耗 :38.1 MB, 在所有 java 提交中击败了89.61%的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        List<Character> characters = new ArrayList<>();
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = characters.indexOf(chars[i]);
            while (characters.indexOf(chars[i]) > -1) {
                characters.remove(0);
            }
            characters.add(chars[i]);
            System.out.println(characters);
            if (max < characters.size()) {
                max = characters.size();
            }
        }
        return max;
    }
}
