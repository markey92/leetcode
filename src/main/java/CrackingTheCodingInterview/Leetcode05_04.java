package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode05_04
 * @Author: markey
 * @Description:
 * @Date: 2020/10/25 22:22
 * @Version: 1.0
 */
public class Leetcode05_04 {
    public int[] findClosedNumbers(int num) {
        /**
         * 比 num 大的数：从右往左，找到第一个 01 位置，然后把 01 转为 10，右侧剩下的 1 移到右侧的低位，右侧剩下的位清0。
         * 比 num 小的数：从右往左，找到第一个 10 位置，然后把 10 转为 01，右侧剩下的 1 移到右侧的高位，右侧剩下的位置0。
         *
         * 作者：wushaoling
         * 链接：https://leetcode-cn.com/problems/closed-number-lcci/solution/wei-yun-suan-by-wushaoling-2/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        int min = findFirstSmall(num);
        int max = findFirstLarge(num);
        return new int[] {max, min};
    }
    private int findFirstSmall(int num) {
        int[] array = new int[32];
        for (int i = 31; num > 0; i--) {
            array[i] = num & 1;
            num >>= 1;
        }
        for (int i = 31; i > 0; i--) {
            // 找到第一个10
            if (array[i - 1] == 1 && array[i] == 0) {
                // 将第一个10变为01
                array[i - 1] = 0;
                array[i] = 1;
                // 把右边所有的1移到高位
                int left = i, right = 31;
                while (left < right) {
                    while (left < 32 && array[left] != 0) {
                        left++;
                    }
                    while (right >= 0 && array[right] != 1) {
                        right--;
                    }
                    if (left < right) {
                        array[left] = 1;
                        array[right] = 0;
                        left++;
                        right--;
                    }
                }
                // 二进制转十进制
                int res = 0;
                for (int j = 0; j < 32; j++) {
                    res = res << 1;
                    res += array[j];
                }
                return res;
            }
        }
        return -1;
    }

    private int findFirstLarge(int num) {
        int[] array = new int[32];
        for (int i = 31; num > 0; i--) {
            array[i] = num & 1;
            num >>= 1;
        }
        for (int i = 31; i > 0; i--) {
            // 找到第一个01
            if (array[i - 1] == 0 && array[i] == 1 ) {
                // 将第一个01变为10
                array[i] = 0;
                array[i - 1] = 1;
                // 把右边所有的1移到低位
                int left = i, right = 31;
                while (left < right) {
                    while (left < 32 && array[left] != 1) {
                        left++;
                    }
                    while (right >= 0 && array[right] != 0) {
                        right--;
                    }
                    if (left < right) {
                        array[left] = 0;
                        array[right] = 1;
                        left++;
                        right--;
                    }
                }
                // 二进制转十进制
                int res = 0;
                for (int j = 0; j < 32; j++) {
                    res = res << 1;
                    res += array[j];
                }
                if (res < num) {
                    return -1;
                }
                return res;
            }
        }
        return -1;
    }
}
