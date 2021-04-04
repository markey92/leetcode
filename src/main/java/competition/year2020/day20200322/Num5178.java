package competition.year2020.day20200322;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200322
 * @ClassName: Num5178
 * @Author: markey
 * @Description:
 * @Date: 2020/3/22 10:37
 * @Version: 1.0
 */
public class Num5178 {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] temp = fourDivisors(nums[i]);
            for (int j = 0; j < temp.length; j++) {
                res += temp[j];
            }
        }
        return res;
    }

    private int[] fourDivisors(int num) {
        int[] res = new int[4];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (index > 3) {
                    return new int[]{};
                }
                res[index] = i;
                index++;
            }
        }
        if (index == 4) {
            return res;
        } else {
            return new int[]{};
        }
    }
}
