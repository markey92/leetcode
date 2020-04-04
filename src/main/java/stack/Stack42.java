package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack42
 * @Author: markey
 * @Description:42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @Date: 2020/4/4 10:55
 * @Version: 1.0
 */
public class Stack42 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int[] lMax = new int[height.length];
        lMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(height[i], lMax[i-1]);
        }

        int[] rMax = new int[height.length];
        rMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i+1]);
        }
        System.out.println(Arrays.toString(lMax));
        System.out.println(Arrays.toString(rMax));
        int res = 0;
        // 除去前后两个柱子处肯定没法积水，计算所有可能的积水
        for (int i = 1; i < height.length - 1; i++) {
            int temp = Math.min(lMax[i-1], rMax[i+1]) - height[i];
            System.out.println(temp);
            res += temp > 0 ? temp : 0;
        }
        return res;
    }
}
