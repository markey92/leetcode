package competition.year2020.day20200822;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200822
 * @ClassName: Leetcode5480
 * @Author: markey
 * @Description:
 * @Date: 2020/8/22 22:36
 * @Version: 1.0
 */
public class Leetcode5480 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> noResult = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            noResult.add(edges.get(i).get(1));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!noResult.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
