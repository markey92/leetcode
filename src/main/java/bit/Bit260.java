package bit;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: Bit260
 * @Author: markey
 * @Description:
 * @Date: 2020/2/16 21:31
 * @Version: 1.0
 */
public class Bit260 {
    /**
     * 1、全员异或，得到两个唯一数的异或结果
     * 2、取异或结果的最后一位1，说明这两个数在这一位是不同的
     * 3、根据这一位将所有数字分成两组，可以将两个唯一数分开
     * 4、两组分别异或得到两个唯一数。
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        // 1、全员异或，得到两个唯一数的异或结果
        int num1 = 0;
        for (int i = 0; i < nums.length; i++) {
            num1 ^= nums[i];
        }
        // 2、取异或结果的最后一位1，说明这两个数在这一位是不同的
        int bit = num1 & (-num1);
        // 3、根据这一位将所有数字分成两组，可以将两个唯一数分开
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            // 4、两组分别异或得到两个唯一数。
            if ((nums[i] & bit) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[] {a, b};
    }
}
