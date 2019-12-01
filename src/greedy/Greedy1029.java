package greedy;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: greedy
 * @ClassName: Greedy1029
 * @Author: markey
 * @Description:
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *  
 *
 * 提示：
 *
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1 21:00
 * @Version: 1.0
 */
public class Greedy1029 {
    /**
     * 假设全部2N人都飞往A，然后再计算每个人去B可能节省的费用，调最省钱的N个人飞去B
     * Runtime: 1 ms, faster than 98.64% of Java online submissions for Two City Scheduling.
     * Memory Usage: 39 MB, less than 63.89% of Java online submissions for Two City Scheduling.
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        int count = 0;
        int[] temp = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            count += costs[i][0];
            temp[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(temp);
        for (int i = 0; i < costs.length / 2; i++) {
            count += temp[i];
        }
        return count;
    }
}
