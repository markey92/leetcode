package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack739
 * @Author: markey
 * @Description:
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:22
 * @Version: 1.0
 */
public class Stack739 {

    /**
     * 执行用时 :75 ms, 在所有 java 提交中击败了65.06%的用户
     * 内存消耗 :43.9 MB, 在所有 java 提交中击败了81.40%的用户
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int days = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length-1; i >=0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
