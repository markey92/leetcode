package lcof;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF60
 * @Author: markey
 * @Description:面试题60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 *
 * 限制：
 *
 * 1 <= n <= 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/27 0:04
 * @Version: 1.0
 */
public class LCOF60 {
    public double[] twoSum(int n) {
        double[] res = new double[7];
        for (int i = 1; i <= 6; i++) {
            res[i] = 1.0 / 6;
        }
        for (int num = 2; num <= n; num++) {
            // i == 1时，有2个骰子，总共所有可能结果有2-12共 11 种，即 5 * 2 + 1
            // 有num个骰子，总共所有可能结果为num-6num，共5n + 1种
            // 为了好理解，我们直接创建一个长度为6*num + 1的数组，索引为i表示总和为i的可能性
            double[] temp = new double[6 * num + 1];
            // 前num-1个骰子的值可能是num-1到6num-6
            // 遍历num-1到6num-6 每种可能性
            for (int X = num - 1; X <= 6 * num - 6; X++) {
                // 假设此时前num-1个骰子的和为 X，最后一颗骰子可能是1-6
                for (int k = 1; k <= 6; k++) {
                    temp[X + k] += res[X] / 6;
                }
            }
            res = temp;
        }

        return Arrays.copyOfRange(res, n, 6*n+1);
    }
}
