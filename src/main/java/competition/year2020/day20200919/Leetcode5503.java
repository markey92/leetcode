package competition.year2020.day20200919;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200919
 * @ClassName: Leetcode5503
 * @Author: markey
 * @Description:
 * @Date: 2020/9/19 22:30
 * @Version: 1.0
 */
public class Leetcode5503 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += sumOddLengthSubarrays(arr, i);
        }
        return res;
    }

    public int sumOddLengthSubarrays(int[] arr, int i) {
        int res =arr[i];
        int count = arr[i];
        int left = i - 1;
        int right = i + 1;
        while (left >= 0 && right < arr.length) {
            count += arr[left];
            count += arr[right];
            res += count;
            left -= 1;
            right += 1;
        }
        System.out.println(res);
        return res;
    }
}
