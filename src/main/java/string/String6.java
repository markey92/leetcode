package string;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String6
 * @Author: markey
 * @Description:6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/27 22:29
 * @Version: 1.0
 */
public class String6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        boolean direction = true; // ture表示向下读取
        int row = 0; // 表示当前行数
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        // 需要读取n个字符
        for (int i = 0; i < s.length(); i++) {
            sbs[row].append(s.charAt(i));
            if (row == 0) {
                direction = true;
            }
            if (row == numRows-1) {
                direction = false;
            }
            if (direction) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
            res.append(sbs[i]);
        }
        return res.toString();
    }
}
