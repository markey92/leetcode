package competition.year2021.day20211017;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211017
 * @ClassName: Leetcode5904
 * @Author: markey
 * @Description:
 * @Date: 2021/10/17 10:42
 * @Version: 1.0
 */
public class Leetcode5904 {
    public int countMaxOrSubsets(int[] nums) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max |= nums[i];
        }
        int status = 1 << nums.length;
        for (int i = 1; i < status; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((1 << j) & i) != 0) {
                    temp |= nums[j];
                }
            }
            System.out.println(temp + " " + max);
            if (temp == max) {
                System.out.println(Integer.toBinaryString(i));
                res++;
            }
        }
        return res;
    }
}
