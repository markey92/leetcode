package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array78
 * @Author: markey
 * @Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:25
 * @Version: 1.0
 */
public class Array78 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
     * Memory Usage: 37.2 MB, less than 99.18% of Java online submissions for Subsets.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        for(int num: nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}
