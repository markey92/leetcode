package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String22
 * @Author: markey
 * @Description:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:47
 * @Version: 1.0
 */
public class String22 {
    /**
     * Runtime: 2 ms, faster than 20.17% of Java online submissions for Generate Parentheses.
     * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Generate Parentheses.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<StringBuilder> res = generateString(new StringBuilder(""), 0, 0, n);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            result.add(res.get(i).toString());
        }
        return result;
    }
    private List<StringBuilder> generateString(StringBuilder root, int left, int right, int n) {
        List<StringBuilder> res = new ArrayList<>();
        if (left >= n) {
            StringBuilder rootCopy = new StringBuilder(root);
            for (int i = 0; i < n - right; i++) {
                rootCopy.append(')');
            }
            res.add(rootCopy);
        } else if (left > right) {
            res.addAll(generateString(new StringBuilder(root).append('('), left+1, right, n));
            res.addAll(generateString(new StringBuilder(root).append(')'), left, right+1, n));
        } else {
            res.addAll(generateString(new StringBuilder(root).append('('), left+1, right, n));
        }
        return res;
    }
}
