package competition.day20200223;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200223
 * @ClassName: Num5171
 * @Author: markey
 * @Description:5171. 最接近的因数
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 *
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 * 示例 1：
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 * 示例 2：
 * 输入：num = 123
 * 输出：[5,25]
 * 示例 3：
 * 输入：num = 999
 * 输出：[40,25]
 * 提示：
 * 1 <= num <= 10^9
 * @Date: 2020/2/23 11:08
 * @Version: 1.0
 */
public class Num5171 {
    // 从开平方开始遍历
    public int[] closestDivisors2(int num) {
        for (int i = (int) Math.sqrt(num + 2); i > 0; i--) {
            if ((num + 1) % i == 0) {
                return new int[] {i, (num + 1) / i};
            }
            if ((num + 2) % i == 0) {
                return new int[] {i, (num + 2) / i};
            }
        }
        return new int[] {1, num + 1};
    }
}
