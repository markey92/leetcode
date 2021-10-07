package competition.year2021.day20210411;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210411
 * @ClassName: Leetcode5729
 * @Author: markey
 * @Description:
 * @Date: 2021/4/11 10:55
 * @Version: 1.0
 */
public class Leetcode5729 {
    // 用list会超时，用数组快一点，不会超时
    class MKAverage {
        int[] nums;
        int count;
        int m;
        int k;
        public MKAverage(int m, int k) {
            this.count = 0;
            this.nums = new int[m];
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            this.nums[count % m] = num;
            count++;
        }

        public int calculateMKAverage() {
            if (this.count < m) {
                return -1;
            }
            int[] temp = Arrays.copyOfRange(this.nums, 0, m);
            Arrays.sort(temp);
            long sum = 0;
            for (int i = k; i < m - k; i++) {
                sum += temp[i];
            }
            return (int) (sum / (m - k * 2));
        }
    }
}
