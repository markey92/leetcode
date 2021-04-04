package competition.year2020.day20200613;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200613
 * @ClassName: Array5423
 * @Author: markey
 * @Description:
 * @Date: 2020/6/13 22:41
 * @Version: 1.0
 */
public class Array5423 {

    public static void main(String[] args) {
        System.out.println(minSumOfLengths(new int[] {1,6,1},7));
    }
    public static int minSumOfLengths(int[] arr, int target) {
        if (arr.length < 2) {
            return -1;
        }

        int length1 = Integer.MAX_VALUE;
        int length2 = Integer.MAX_VALUE;
        int lastIndex = -1;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end <= arr.length) {
            if (sum < target) {
                if (end < arr.length) {
                    sum += arr[end];
                }
                end++;
                continue;
            } else if (sum > target) {
                if (start < arr.length) {
                    sum -= arr[start];
                }
                start++;
                continue;
            } else {
                if (start < lastIndex) {
                    if (end - start < length2) {
                        length2 = end - start;
                        lastIndex = end;
                    }
                } else if (end - start < Math.max(length1, length2)) {
                    length1 = Math.min(length1, length2);
                    length2 = end - start;
                    lastIndex = end;
                }
            }
            if (end < arr.length) {
                sum += arr[end];
            }
            if (start < arr.length) {
                sum -= arr[start];
            }
            end++;
            start++;
        }
        if (length1 == Integer.MAX_VALUE) {
            return -1;
        }
        return length1 + length2;
    }
}
