package competition.day20210822;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210822
 * @ClassName: Leetcode5851
 * @Author: markey
 * @Description:
 * @Date: 2021/8/22 10:38
 * @Version: 1.0
 */
public class Leetcode5851 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] numInts = new int[nums.length];
        for (int i = 0; i < n; i++) {
            numInts[i] = prase(nums[i]);
        }
        System.out.println(Arrays.toString(numInts));
        String result = "";
        for (int i = 0; i < 2 << n; i++) {
            boolean exist = false;
            for (int j = 0; j < n; j++) {
                if ((numInts[j] ^ i) == 0) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                result = Integer.toBinaryString(i);
                break;
            }
        }
        while (result.length() < n) {
            result = "0" + result;
        }
        return result;
    }

    private int prase(String num) {
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            res += (num.charAt(num.length() - 1 - i) - '0') << i;
        }
        return res;
    }
}
