package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp11
 * @Author: markey
 * @Description:11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/18 21:43
 * @Version: 1.0
 */
public class Dp11 {
    // 双指针
    public int maxArea3(int[] height) {
        int result = 0;
        int i=0, j=height.length-1;
        int tmp =0;
        while(i!=j){
            if(height[i] < height[j]){
                tmp = (j-i)*height[i];
                i++;
            }else{
                tmp = (j-i)*height[j];
                j--;
            }
            if(tmp > result){
                result = tmp;
            }
        }
        return result ;
    }
    // 暴力破解3
    // 再优化一点点
    public int maxArea2(int[] height) {
        int max = Integer.MIN_VALUE;
        int preHeight = 0;
        for (int i = height.length - 1; i > 0; i--) {
            if (i < height.length - 1 && height[i] <= preHeight) {
                continue;
            }
            preHeight = height[i];
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.min(height[j], height[i]) * (i - j));
                if (height[j] >= height[i]) {
                    break;
                }
            }
        }
        return max;
    }
    // 暴力破解2
    // 优化一点点
    public int maxArea1(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.min(height[j], height[i]) * (i - j));
                if (height[j] >= height[i]) {
                    break;
                }
            }
        }
        return max;
    }
    // 暴力破解
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.min(height[j], height[i]) * (i - j));
            }
        }
        return max;
    }
}
