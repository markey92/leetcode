package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack84
 * @Author: markey
 * @Description:84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/4 17:09
 * @Version: 1.0
 */
public class Stack84 {
    // 遍历让每根柱子作为高时，可以获得矩形的面积，求出最大值
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            // 新的柱子比单调栈的栈顶小时，得到了右边界
            while (stack.peek() != -1 && heights[stack.peek()] > height) {
                // i表示左边边界，比当前柱子小的最大一个柱子
                // stack.peek 就是比当前柱子小的一个柱子，用来围成一个最大矩形（不包含这根柱子的）
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        // 最后的单调栈的处理
        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
            res = Math.max(res, area);
        }
        return res;
    }
}
