package lcof;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF38
 * @Author: markey
 * @Description:面试题38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/28 22:20
 * @Version: 1.0
 */
public class LCOF38 {

    public static void main(String[] args) {
        String[] res = permutation("abc");
        for (String s: res) {
            System.out.println(s);
        }
    }
    public static String[] permutation(String s) {
        if (s.length() <= 1) {
            return new String[] {s};
        }
        List<String> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                String[] childern = permutation(new StringBuilder(s).deleteCharAt(i).toString());
                for (String child: childern) {
//                    System.out.println(new StringBuilder(child).insert(0, s.charAt(i)).toString());
                    res.add(new StringBuilder(child).insert(0, s.charAt(i)).toString());
                }
            }
        }
        return res.toArray(new String[]{});
    }
}
