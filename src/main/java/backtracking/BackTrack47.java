package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: backtracking
 * @ClassName: BackTack47
 * @Author: markey
 * @Description:47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/25 22:08
 * @Version: 1.0
 */
public class BackTrack47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (list.size() == 1) {
            res.add(list);
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(i);
            List<List<Integer>> subList = permuteUnique(list.stream().mapToInt(Integer::intValue).toArray());
            subList.forEach(sub -> {
                sub.add(temp);
                res.add(sub);
            });
            list.add(i, temp);
        }
        return res.stream().distinct().collect(Collectors.toList());
    }
}
