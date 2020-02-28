package lcof;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF45
 * @Author: markey
 * @Description:面试题45. 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/28 0:21
 * @Version: 1.0
 */
public class LCOF45 {

    /**
     * 排序后拼接
     *
     * a 和 b谁放前面，直接比较 ab 和ba谁大
     * 例如 35 351 因为35135 比 35351小，所351放前面
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        int[] res = Arrays.stream(nums).
                boxed().
                sorted((o1, o2) -> compare(String.valueOf(o1), String.valueOf(o2))). // sort descending
                mapToInt(i -> i).
                toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                sb.append(res[i]);
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compare("128", "12"));
    }
    private static int compare(String a, String b) {
        return (int) (Long.valueOf(a+b) - Long.valueOf(b+a));
    }
}
