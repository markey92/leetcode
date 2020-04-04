package string;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String820
 * @Author: markey
 * @Description:820. 单词的压缩编码
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 * @Date: 2020/3/28 21:51
 * @Version: 1.0
 */
public class String820 {
    public int minimumLengthEncoding1(String[] words) {
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words[i].length(); j++) {
                set.remove(words[i].substring(j));
            }
        }
        int num = 0;
        for (String word : set) {
            num += word.length() + 1;
        }
        return num;
    }
    public int minimumLengthEncoding(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (res.isEmpty()) {
                res.add(word);
            }
            boolean isExit = false;
            for (int i = 0; i < res.size(); i++) {
                if (word.length() > res.get(i).length() && word.substring(word.length() - res.get(i).length()).equals(res.get(i))) {
                    res.set(i, word);
                    isExit = true;
                    break;
                } else if (word.length() <= res.get(i).length() && res.get(i).substring(res.get(i).length() - word.length()).equals(word)) {
                    isExit = true;
                    break;
                }
            }
            if (!isExit) {
                res.add(word);
            }
        }
        int num = 0;
        for (String word : res) {
            num += word.length() + 1;
        }
        return num;
    }
}
