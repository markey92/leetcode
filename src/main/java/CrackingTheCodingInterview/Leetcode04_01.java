package CrackingTheCodingInterview;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_01
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 23:00
 * @Version: 1.0
 */
public class Leetcode04_01 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 记录每个节点可到达的下一个节点列表
        List<Integer>[] nextList = new List[n];
        for (int i = 0; i < graph.length; i++) {
            int from = graph[i][0];
            int to = graph[i][1];
            if (nextList[from] == null) {
                nextList[from] = new ArrayList<>();
            }
            nextList[from].add(to);
        }
        // 判断是否可达
        List<Integer> hasReach = new ArrayList<>();
        return checkTarget(nextList, start, target, hasReach);
    }

    private boolean checkTarget(List<Integer>[] nextList, int source, int target, List<Integer> hasReach) {
        List<Integer> canReach = nextList[source];
        if (canReach == null || canReach.size() == 0) {
            return false;
        }
        for (int i = 0; i < canReach.size(); i++) {
            int next = canReach.get(i);
            if (hasReach.contains(next)) {
                // 已经走过的节点，避免自环
                continue;
            }
            if (next == target) {
                // 找到目标
                return true;
            } else {
                hasReach.add(next);
                boolean res = checkTarget(nextList, next, target, hasReach);
                if (res) {
                    // 找到目标
                    return true;
                } else {
                    // 未找到目标，此时需要将上个节点标为未走过
                    hasReach.remove(hasReach.size() - 1);
                }
            }
        }
        return false;
    }
}
