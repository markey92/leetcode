package competition.year2020.day20200308;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200308
 * @ClassName: Tree5355
 * @Author: markey
 * @Description:5355. T 秒后青蛙的位置
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 *
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [fromi, toi] 意味着存在一条直接连通 fromi 和 toi 两个顶点的边。
 *
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * 输出：0.3333333333333333
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
 * 示例 3：
 *
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6
 * 输出：0.166666666666666663
 *
 * 提示：
 *
 * 1 <= n <= 100
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= edges[i][0], edges[i][1] <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 * 与准确值误差在 10^-5 之内的结果将被判定为正确。
 * 通过次数683提交次数3,127
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-position-after-t-seconds
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/8 12:56
 * @Version: 1.0
 */
public class Tree5355 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map1.containsKey(edges[i][0])) {
                map1.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                map1.put(edges[i][0], list);
            }
            if (map2.containsKey(edges[i][1])) {
                map2.get(edges[i][1]).add(edges[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][0]);
                map2.put(edges[i][1], list);
            }
        }
        System.out.println(map1);
        System.out.println(map2);
        if (map1.containsKey(1)) {
            return frogPosition(map1, 1, t, target);
        } else {
            return frogPosition(map2, 1, t, target);
        }
    }

    private double frogPosition(Map<Integer, List<Integer>> map, int node, int t, int target) {
        List<Integer> nextNode = map.get(node);
        if (nextNode == null) {
            return node == target ? 1 : 0;
        }
        if (t == 1) {
            if (nextNode.contains(target)) {
                return 1.0 / nextNode.size();
            } else {
                return 0.0;
            }
        }
        double temp = 0;
        for (int i = 0; i < nextNode.size(); i++) {
            temp += frogPosition(map, nextNode.get(i), t - 1, target);
        }
        System.out.println("node:" + node + " maybe:" + nextNode.size());
        return nextNode.size() == 0 ? (node == target ? 1 : 0) : temp / nextNode.size();
    }
}
