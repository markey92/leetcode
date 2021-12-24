package competition.day20211212;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211212
 * @ClassName: Leetcode5954
 * @Author: markey
 * @Description:
 * @Date: 2021/12/12 10:43
 * @Version: 1.0
 */
public class Leetcode5954 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int left = 0;
        int right = plants.length - 1;
        int waterA = capacityA;
        int waterB = capacityB;
        while (left <= right) {
            if (left == right) {
                if (Math.max(waterA, waterB) < plants[left]) {
                    res++;
                }
            } else {
                if (waterA < plants[left]) {
                    waterA = capacityA;
                    res++;
                }
                if (waterB < plants[right]) {
                    waterB = capacityB;
                    res++;
                }
                waterA -= plants[left];
                waterB -= plants[right];
            }
            left++;
            right--;
        }
        return res;
    }
}
