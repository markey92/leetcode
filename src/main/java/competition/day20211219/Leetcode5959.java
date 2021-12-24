package competition.day20211219;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211219
 * @ClassName: Leetcode5959
 * @Author: markey
 * @Description:
 * @Date: 2021/12/19 10:45
 * @Version: 1.0
 */
public class Leetcode5959 {
    public static void main(String[] args) {
        Leetcode5959 leetcode5959 = new Leetcode5959();
        leetcode5959.kIncreasing(new int[] {12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3}, 1);
    }
    public int kIncreasing(int[] arr, int k) {
        int count = 0;
        Set<Integer> hadChange = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
            int min = arr[i + k];
            if (i + 2 * k < arr.length) {
                min = Math.min(min, arr[i + 2 * k]);
            }
            if (arr[i - k] <= arr[i + k]) {
                if (arr[i] < arr[i - k] || arr[i] > arr[i + k]) {
                    if (hadChange.contains(i))
                    arr[i] = arr[i - k];
                    hadChange.add(i);
                    count++;
                }
            } else {
                arr[i - k] = arr[i + k];
                count++;
            }
        }
        return count;
    }
}
