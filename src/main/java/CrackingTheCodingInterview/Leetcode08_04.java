package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_04
 * @Author: markey
 * @Description:
 * @Date: 2020/9/26 23:31
 * @Version: 1.0
 */
public class Leetcode08_04 {
    public List<List<Integer>> subsets(int[] nums) {

        // 暴力遍历
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> firstNode = Collections.EMPTY_LIST;
        res.add(firstNode);

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newNode = new ArrayList<>(res.get(i));
                newNode.add(num);
                res.add(newNode);
            }
        }
        return res;
    }
}
