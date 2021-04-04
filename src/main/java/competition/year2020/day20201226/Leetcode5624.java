package competition.year2020.day20201226;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201226
 * @ClassName: Leetcode5624
 * @Author: markey
 * @Description:
 * @Date: 2020/12/26 23:56
 * @Version: 1.0
 */
public class Leetcode5624 {
    public int minMoves(int[] nums, int k) {
        List<Integer> preList = new ArrayList<>();
        int indexLastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (indexLastOne == -1) {
                    indexLastOne = i - 1;
                }
                preList.add(i - indexLastOne - 1);
                indexLastOne = i;
            }
        }
        System.out.println(preList);
        List<Integer> lastList = new ArrayList<>();
        indexLastOne = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                if (indexLastOne == nums.length) {
                    indexLastOne = i + 1;
                }
                lastList.add(indexLastOne - i - 1);
                indexLastOne = i;
            }
        }
        System.out.println(lastList);
        int res = Integer.MAX_VALUE;
        for (int i = k; i <= preList.size(); i++) {
            res = Math.min(preList.subList(i - k, i).stream().mapToInt(Integer::intValue).sum(), res);
            res = Math.min(lastList.subList(i - k, i).stream().mapToInt(Integer::intValue).sum(), res);
        }
        return res;
    }
}
