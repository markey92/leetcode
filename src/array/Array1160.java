package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array1160
 * @Author: markey
 * @Description:
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:16
 * @Version: 1.0
 */
public class Array1160 {

    /**
     * 执行用时 :34 ms, 在所有 java 提交中击败了57.27%的用户
     * 内存消耗 :37.7 MB, 在所有 java 提交中击败了100.00%的用户
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        Map<Character, Integer> type = new HashMap<>();
        for (char c: chars.toCharArray()) {
            type.put(c, type.getOrDefault(c, 0) + 1);
        }
        for (String word: words) {
            Map<Character, Integer> thisWord = new HashMap<>();
            boolean flag = true;
            for (char c: word.toCharArray()) {
                thisWord.put(c, thisWord.getOrDefault(c, 0) + 1);
                if (thisWord.get(c) > type.getOrDefault(c, 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += word.length();
            }
        }
        return res;
    }
}
