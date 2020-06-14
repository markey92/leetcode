package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: backtracking
 * @ClassName: BackTrack40
 * @Author: markey
 * @Description:40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/26 22:36
 * @Version: 1.0
 */
public class BackTrack40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return combinationSum2(Arrays.stream(candidates).boxed().collect(Collectors.toList()), target);
    }

    public List<List<Integer>> combinationSum2(List<Integer> candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            int num = candidates.get(i);
            if (num == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                res.add(temp);
                continue;
            }
            // 回溯
            if (num < target) {
                candidates.remove(i);
                List<List<Integer>> temp = combinationSum2(candidates, target - num);
                temp.forEach(list -> {
                    list.add(num);
                    Collections.sort(list); // 为了最后结果可以去重
                    res.add(list);
                });
                candidates.add(i, num);
            }
        }
        return res.stream().distinct().collect(Collectors.toList()); // 结果去重
    }
}
