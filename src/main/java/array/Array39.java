package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array39
 * @Author: markey
 * @Description:39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/25 21:50
 * @Version: 1.0
 */
public class Array39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                res.add(temp);
                continue;
            }
            if (candidates[i] < target) {
                int temp = candidates[i];
                List<List<Integer>> subList = combinationSum(candidates, target - candidates[i]);
                subList.forEach(sub -> {
                    sub.add(temp);
                    Collections.sort(sub);
                    res.add(sub);
                });
                continue;
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }
}
