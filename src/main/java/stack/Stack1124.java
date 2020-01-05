package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Stack1124
 * @Author: markey
 * @Description:
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *  
 *
 * 提示：
 *
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/1 23:27
 * @Version: 1.0
 */
public class Stack1124 {

    public static void main(String[] args) {
        int[] hours = {9,9,6,0,6,6,9};
        System.out.println(longestWPI(hours));
    }
    public static int longestWPI(int[] hours) {
        // 1、求前缀和；
        int[] preSum = new int[hours.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < hours.length; i++) {
            preSum[i] = preSum[i-1] + (hours[i] > 8 ? 1 : -1);
        }
        // 2、当preSum[j]>preSum[i]时，j-i这段时间是「表现良好的时间段」,需要求j-i的最大值；
        // 3、*从后往前便利preSum*，维护一个递减单调栈，则栈中每个元素都满足preSum[x]>preSum[x++]
        Stack<Integer> stack = new Stack<>();
        for (int i = preSum.length - 1; i >= 0; i--) {
            System.out.println(preSum[i]);
            if (stack.isEmpty() || preSum[stack.peek()-1] > preSum[i]) {
                stack.push(i);
            }
        }
        System.out.println(stack);
        // use i > res optimize
        int res = 0;
        for (int i = hours.length; i > res; --i) {
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }
}
