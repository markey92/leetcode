package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array46
 * @Author: markey
 * @Description:46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/25 22:41
 * @Version: 1.0
 */
public class Array46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        permute(new ArrayList<>(), numList);
        return res;
    }

    public void permute(List<List<Integer>> base, List<Integer> nums) {

        for (int i = 0; i < nums.size(); i++) {
            List<List<Integer>> tempBase = new ArrayList<>(base);
            List<Integer> tempNums = new ArrayList<>(nums);
            if (tempBase.size() == 0) {
                List<Integer> newList = new ArrayList<>();
                newList.add(tempNums.get(i));
                tempBase.add(newList);
            } else {
                for (int j = 0; j < tempBase.size(); j++) {
                    tempBase.get(j).add(tempNums.get(i));
                    tempNums.remove(i);
                    if (tempNums.size() == 0) {
                        System.out.println(base + " " + nums);
                        this.res.addAll(tempBase);
                    } else {
                        permute(tempBase, tempNums);
                    }
                }
            }
        }
    }
}
