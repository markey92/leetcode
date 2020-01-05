package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array820
 * @Author: markey
 * @Description:
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
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
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1 21:16
 * @Version: 1.0
 */
public class Array820 {
    /**
     * 执行用时 :984 ms, 在所有 java 提交中击败了7.50%的用户
     * 内存消耗 :38.7 MB, 在所有 java 提交中击败了93.33%的用户
     * @param words
     * @return
     */
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
