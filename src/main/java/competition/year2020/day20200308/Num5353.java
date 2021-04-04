package competition.year2020.day20200308;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200308
 * @ClassName: Bit5353
 * @Author: markey
 * @Description:5353. 灯泡开关 III
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
 *
 * 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
 *
 * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
 *
 * 灯处于打开状态。
 * 排在它之前（左侧）的所有灯也都处于打开状态。
 * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：light = [2,1,3,5,4]
 * 输出：3
 * 解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
 * 示例 2：
 *
 * 输入：light = [3,2,4,1,5]
 * 输出：2
 * 解释：所有开着的灯都变蓝的时刻分别是 3 和 4（index-0）。
 * 示例 3：
 *
 * 输入：light = [4,1,2,3]
 * 输出：1
 * 解释：所有开着的灯都变蓝的时刻是 3（index-0）。
 * 第 4 个灯在时刻 3 变蓝。
 * 示例 4：
 *
 * 输入：light = [2,1,4,3,6,5]
 * 输出：3
 * 示例 5：
 *
 * 输入：light = [1,2,3,4,5,6]
 * 输出：6
 *  
 *
 * 提示：
 *
 * n == light.length
 * 1 <= n <= 5 * 10^4
 * light 是 [1, 2, ..., n] 的一个排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/8 10:39
 * @Version: 1.0
 */
public class Num5353 {

    public static void main(String[] args) {
        numTimesAllBlue(new int[] {2,1,3,5,4});
    }

    // 最大编号的那个灯是不是目前所有亮灯数，是的话，符合要求
    public static int numTimesAllBlue(int[] light) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (max == i + 1) {
                res++;
            }
        }
        return res;
    }
    //亮灯编号是等差数列的情况符合要求
    public static int numTimesAllBlue2(int[] light) {
        double sum = 0;
        int res = 0;
        for (double i = 0; i < light.length; i++) {
            sum += light[(int)i];
            if (sum == (i + 1) / 2 * (i + 2)) {
                res ++;
            } else {
                System.out.println(sum);
                System.out.println(((i + 1) * (i + 2)) /2);
            }
        }
        System.out.println(res);
        return res;
    }
    // 暴力解法，超时
    public static int numTimesAllBlue1(int[] light) {
        int res = 0;
        int[] state = new int[light.length];
        for (int i = 0; i < light.length; i++) {
            if (light[i] == 1) {
                state[0] = 2;
            } else {
                state[light[i] - 1] = 1;
            }
            update(state);
            for (int j = 0; j < state.length; j++) {
                System.out.print(state[j]);
            }
            System.out.println();
            if (allBlue(state)) {
                res ++;
            }
        }
        System.out.println(res);
        return res;

    }

    private static void update(int[] state) {
        for (int i = 0; i < state.length -1; i++) {
            if (state[i] > 0 && state[i+1] > 0) {
                state[i+1] = 2;
            } else {
                break;
            }
        }
    }

    private static boolean allBlue(int[] state) {
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 1) {
                return false;
            }
        }
        return true;
    }
}
