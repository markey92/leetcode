package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF14_1
 * @Author: markey
 * @Description:面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/24 22:11
 * @Version: 1.0
 */
public class LCOF14_1 {
    public static void main(String[] args) {
        cuttingRope(10);
    }
    //机智法
    // 分解出尽量多的3，可以让乘积最大，如果最后的余数是1，则变成2*2
    public static int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int x = n / 3;
        int res;
        if (n % 3 == 0) {
            res = (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            res = (int) Math.pow(3, n / 3 -1) * 2 * 2;
        } else {
            // n % 3 == 2
            res = (int) Math.pow(3, n / 3) * 2;
        }
        return res;
    }
    // 暴力
    /**
     * 任何一段绳子n都有n-1中剪法：1+（n-1）,2+(n-2),……(n-1)+1;
     * 假设其最大乘积为X（n）,则X（n）=Math.max(1*X（n-1）, 2*X(n-2), ……, (n-1)*X(1));
     * 再考虑到剪了第一段之后，后面N-1段可以不再剪，所以X（n）=MAX(1* Max（(n-1),X（n-1）), 2* MAX((n-2),X(n-2)), ……, (n-1)*MAX(1,X(1)));
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        int[] maxArray = new int[n + 1];
        maxArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1 * maxArray[i - 1];
            for (int j = 2; j < i; j++) {
                max = Math.max(max, j * Math.max((i - j), maxArray[i - j]));
            }
            maxArray[i] = max;
        }
        for (int i = 0; i < maxArray.length; i++) {
            System.out.println(maxArray[i]);
        }
        return maxArray[n];
    }
}
