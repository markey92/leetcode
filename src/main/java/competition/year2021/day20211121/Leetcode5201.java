package competition.year2021.day20211121;

/**
 * @ProjectName: leetcode
 * @Package: competition.year2021
 * @ClassName: Leetcode5201
 * @Author: markey
 * @Description:
 * @Date: 2021/11/21 10:34
 * @Version: 1.0
 */
public class Leetcode5201 {
    public static void main(String[] args) {
        Leetcode5201 leetcode5201 = new Leetcode5201();
        leetcode5201.wateringPlants(new int[] {2,2,3,3}, 5);
    }
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int step = 0;
        int water = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (water >= plants[i]) {
                water -= plants[i];
                res += 1;
            } else {
                res += step * 2 + 1;
                water = capacity - plants[i];
            }
            step += 1;
        }
        return res;
    }
}
