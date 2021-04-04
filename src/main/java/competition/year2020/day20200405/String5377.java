package competition.year2020.day20200405;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200405
 * @ClassName: String5377
 * @Author: markey
 * @Description:5377. 将二进制表示减到 1 的步骤数 显示英文描述
 * 用户通过次数710
 * 用户尝试次数1146
 * 通过次数712
 * 提交次数1581
 * 题目难度Medium
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 *
 * 如果当前数字为偶数，则将其除以 2 。
 *
 * 如果当前数字为奇数，则将其加上 1 。
 *
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 *
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 *
 * 输入：s = "1"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 * @Date: 2020/4/5 10:57
 * @Version: 1.0
 */
public class String5377 {

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (sb.length() != 1) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.append('0');
                for (int i = sb.length() - 2; i >= 0; i--) {
                    if (i == 0 && sb.charAt(i) == '1') {
                        sb.deleteCharAt(i);
                        sb.insert(0, '0');
                        sb.insert(0, '1');
                        break;
                    }
                    if (sb.charAt(i) == '1') {
                        sb.deleteCharAt(i);
                        sb.insert(i, '0');
                    } else {
                        sb.deleteCharAt(i);
                        sb.insert(i, '1');
                        break;
                    }
                }
            }
            System.out.println(sb);
            count++;
        }
        return count;
    }
}
