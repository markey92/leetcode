package num;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Num264
 * @Author: markey
 * @Description:
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1 是丑数。n 不超过1690。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/3 21:56
 * @Version: 1.0
 */
public class Num264 {

    public static void main(String[] args) {
        nthUglyNumber(10);
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了98.74%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了32.73%的用户
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int count = 1;
        int num2 = 0, num3 = 0, num5 = 0;
        int count2 = 0, count3 = 0, count5 = 0;
        while (count < n) {
            num2 = uglyNums[count2] * 2;
            num3 = uglyNums[count3] * 3;
            num5 = uglyNums[count5] * 5;
            int min = Math.min(Math.min(num2, num3), num5);
            System.out.println(min);
            uglyNums[count] = min;
            if (min == num2) {
                count2++;
            }
            if (min == num3) {
                count3++;
            }
            if (min == num5) {
                count5++;
            }
            count++;
        }
        return uglyNums[n-1];
    }
}
