package competition.year2021.day20210523;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210523
 * @ClassName: Leetcode5764
 * @Author: markey
 * @Description:
 * @Date: 2021/5/23 10:34
 * @Version: 1.0
 */
public class Leetcode5764 {
    public static void main(String[] args) {
        int[] dist=new int[] {1, 3, 2};
        System.out.println(minSpeedOnTime(dist, 2.7));
    }
    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10_000_000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (time(dist, mid) <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return time(dist, left) <= hour ? left : -1;
    }

    private static double time(int[] dist, int speed) {
        double count = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            count += dist[i] / speed + ((double) dist[i] % speed > 0 ? 1 : 0);
        }
        count += (double) dist[dist.length - 1] / speed;
        System.out.println(count);
        return count;
    }
}
