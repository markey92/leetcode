package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String557
 * @Author: markey
 * @Description:557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @Date: 2020/4/4 17:13
 * @Version: 1.0
 */
public class String557 {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].isEmpty()) {
                StringBuilder temp = new StringBuilder(array[i]);
                temp.reverse();
                sb.append(temp.toString());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
