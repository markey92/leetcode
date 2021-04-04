package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_09
 * @Author: markey
 * @Description:
 * @Date: 2020/9/27 23:22
 * @Version: 1.0
 */
public class Leetcode08_09 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis("", n, 0, 0);
        return res;
    }

    public void generateParenthesis(String parent, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(parent);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            generateParenthesis(parent + "(", n, left + 1, right);
        }
        if (right < n) {
            generateParenthesis(parent + ")", n, left, right + 1);
        }
    }
}
