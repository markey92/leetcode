package competition.day20200301;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200301
 * @ClassName: Array5344
 * @Author: markey
 * @Description:
 * @Date: 2020/3/1 10:33
 * @Version: 1.0
 */
public class Array5344 {
    public static void main(String[] args) {
        smallerNumbersThanCurrent(new int[] {6,5,4,8});
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] sortNums = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sortNums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortNums.length; i++) {
            if (i < 1 || sortNums[i] != sortNums[i - 1]) {
                map.put(sortNums[i], i);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums[i]);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }
}
