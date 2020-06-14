package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array447
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 23:12
 * @Version: 1.0
 */
public class Array447 {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int[] middle: points) {
            // 记录每个其他点到这个点的距离，如果距离相同的点有n个，则回旋标的个数是n中选2个的种类数
            Map<Double, Integer> map = new HashMap<>();
            for (int[] point: points) {
                if (point[0] == middle[0] && point[1] == middle[1]) {
                    // 相同点忽略
                    continue;
                }
                double distance = distance(middle, point);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            // 计算个数
            for (double distance : map.keySet()) {
                count += map.get(distance) * (map.get(distance) - 1);
            }
        }
        return count;
    }

    // 暴力遍历，超时
    public int numberOfBoomerangs1(int[][] points) {
        int count = 0;
        for (int[] middle: points) {
            for (int[] left: points) {
                if (left[0] == middle[0] && left[1] == middle[1]) {
                    // 相同点忽略
                    continue;
                }
                double distance = distance(middle, left);
                for (int[] right: points) {
                    if (left[0] == right[0] && left[1] == right[1]) {
                        // 相同点忽略
                        continue;
                    }
                    if (distance(middle, right) == distance) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private double distance(int[] point1, int[] point2) {
        return Math.pow((point1[0] -point2[0]), 2.0) + Math.pow((point1[1] -point2[1]), 2);
    }
}
