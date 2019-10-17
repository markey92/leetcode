package sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: Sort1122
 * @Author: markey
 * @Description:
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:14
 * @Version: 1.0
 */
public class Sort1122 {

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了94.23%的用户
     * 内存消耗 :36.1 MB, 在所有 java 提交中击败了100.00%的用户
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //找出最大值和最小值
        int max = arr1[0], min = arr1[0];
        for (int i: arr1) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }

        }
        //统计每个数出现的次数
        int[] count = new int[max - min + 1];
        for (int i: arr1) {
            count[i - min]++;
        }
        //按照arr2的顺序构造结果；
        int[] result = new int[arr1.length];
        int index = 0;
        //处理arr2中出现的数字
        for(int i: arr2) {
            while (count[i - min] > 0) {
                result[index] = i;
                index++;
                count[i - min] --;
            }
        }
        //处理arr2中未出现的数字
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index] = i + min;
                index++;
                count[i] --;
            }
        }
        return result;
    }
    /**
     * 自定义排序比较方法
     * Runtime: 44 ms, faster than 5.94% of Java online submissions for Relative Sort Array.
     * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Relative Sort Array.
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            order.put(arr2[i], i);
        }

        System.out.println(order);
        List<Integer> arr1List = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        arr1List.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return order.getOrDefault(o1, o1 + arr2.length) - order.getOrDefault(o2.intValue(), o2 + arr2.length);
            }
        });
        return arr1List.stream().mapToInt(Integer::intValue).toArray();
    }
}
