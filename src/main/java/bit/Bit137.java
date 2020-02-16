package bit;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: Bit137
 * @Author: markey
 * @Description:
 * @Date: 2020/2/16 21:16
 * @Version: 1.0
 */
public class Bit137 {
    /**
     * 原理：二进制的0-32位上，如果某个数出现了 3次，那么这一位出现1的次数肯定是3
     * 100100
     * 100100
     * 100100
     * 000001
     * 将每一位的1个数%3就是那个唯一的数的值
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & bit) != 0) {
                    count ++;
                }
            }
            if (count % 3 != 0) {
                res = res | bit;
            }
            bit = bit << 1;
        }
        return res;
    }
}
