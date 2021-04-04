package competition.year2020.day20200223;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200223
 * @ClassName: Num5173
 * @Author: markey
 * @Description:5172. 形成三的最大倍数
 * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
 * 如果无法得到答案，请返回一个空字符串。
 * 示例 1：
 * 输入：digits = [8,1,9]
 * 输出："981"
 * 示例 2：
 * 输入：digits = [8,6,7,1,0]
 * 输出："8760"
 * 示例 3：
 * 输入：digits = [1]
 * 输出：""
 * 示例 4：
 * 输入：digits = [0,0,0,0,0,0]
 * 输出："0"
 * 提示：
 * 1 <= digits.length <= 10^4
 * 0 <= digits[i] <= 9
 * 返回的结果不应包含不必要的前导零。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-multiple-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/23 12:11
 * @Version: 1.0
 */
public class Num5173 {
    /**
     * 涉及的点：
     * 1、十进制各位数字之和能被 3 整除的数,本身也能被 3 整除
     * 2、两组除以3余数为1或者2的数
     * 如果和除以3的余数位1，则除掉一个余数位1的数字或者两个余数位2的数字后符合条件；
     * 如果和除以3的余数位2，则除掉一个余数位2的数字或者两个余数位1的数字后符合条件；
     * 本题的结果要求数字个数越多越好
     * @param digits
     * @return
     */
    public String largestMultipleOfThree(int[] digits) {
        List<Integer> remainder0 = new ArrayList<>();
        List<Integer> remainder1 = new ArrayList<>();
        List<Integer> remainder2 = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == 0) {
                remainder0.add(digits[i]);
            } else if (digits[i] % 3 == 1) {
                remainder1.add(digits[i]);
            } else {
                remainder2.add(digits[i]);
            }
            sum += digits[i];
        }
        int x = sum % 3;
        int remainder1Num = remainder1.size(), remainder2Num = remainder2.size();
        if (x == 1) {
            if (remainder1Num > 0) {
                remainder1Num -= 1;
            } else {
                remainder2Num -= 2;
            }
        } else if (x == 2) {
            if (remainder2Num > 0) {
                remainder2Num -= 1;
            } else {
                remainder1Num -= 2;
            }
        }
        remainder1 = remainder1.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(remainder1Num).collect(Collectors.toList());
        remainder2 = remainder2.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(remainder2Num).collect(Collectors.toList());
        remainder0.addAll(remainder1);
        remainder0.addAll(remainder2);
        remainder0 = remainder0.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());
        if (remainder0.size() > 0 && remainder0.get(0) == 0) {
            return "0";
        }
        return remainder0.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
