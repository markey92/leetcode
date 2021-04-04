package competition.year2020.day20200808;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200808
 * @ClassName: Leetcode5468
 * @Author: markey
 * @Description:
 * @Date: 2020/8/8 22:30
 * @Version: 1.0
 */
public class Leetcode5468 {
    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        int num = 0;
        for (int i = 1; i <= 1000000; i++) {
            if (index < arr.length && arr[index] == i) {
                index++;
                continue;
            }
            num++;
            if (num == k) {
                return i;
            }
        }
        return -1;
    }
}
