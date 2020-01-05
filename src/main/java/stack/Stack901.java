package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack901
 * @Author: markey
 * @Description:
 * @Date: 2019/10/18 0:24
 * @Version: 1.0
 */
public class Stack901 {

    /**
     * 执行用时 :142 ms, 在所有 java 提交中击败了82.40%的用户
     * 内存消耗 :70.5 MB, 在所有 java 提交中击败了95.00%的用户
     */
    class StockSpanner {

        List<Integer> prices;
        Stack<Integer> stack;
        int today;
        public StockSpanner() {
            prices = new ArrayList<>();
            stack = new Stack<>();
            today = 0;
        }

        public int next(int price) {
            prices.add(price);
            while (!stack.isEmpty() && prices.get(stack.peek()-1) <= price) {
                stack.pop();
            }
            int firstMax = stack.isEmpty() ? 0 : stack.peek();
            today++ ;
            stack.push(today);
            return today - firstMax;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
