package competition.day20210417;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210417
 * @ClassName: Leetcode
 * @Author: markey
 * @Description:
 * @Date: 2021/4/17 22:40
 * @Version: 1.0
 */
public class Leetcode5719 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int k = (int) Math.pow(2, maximumBit) - 1;
        System.out.println(k);
        int all = 0;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            all ^= nums[n - 1 - i];
            System.out.println(Integer.toBinaryString(all));
            int temp = all & k;
            System.out.println(Integer.toBinaryString(temp));
            res[i] = k ^ temp;
        }
        return res;
    }
}
