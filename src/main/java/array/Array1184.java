package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array1184
 * @Author: markey
 * @Description:
 * @Date: 2020/6/21 12:05
 * @Version: 1.0
 */
public class Array1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int all = 0;
        int des = 0;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i = 0; i < distance.length; i++) {
            all += distance[i];
            if (i >= start && i < destination) {
                des += distance[i];
            }
        }
        return Math.min(all - des, des);
    }
}
