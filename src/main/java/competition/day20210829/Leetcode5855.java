package competition.day20210829;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210829
 * @ClassName: Leetcode5855
 * @Author: markey
 * @Description:
 * @Date: 2021/8/29 10:35
 * @Version: 1.0
 */
public class Leetcode5855 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }
}
