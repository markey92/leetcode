package competition.year2020.day20200719;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200719
 * @ClassName: Leetcode5465
 * @Author: markey
 * @Description:
 * @Date: 2020/7/19 10:40
 * @Version: 1.0
 */
public class Leetcode5465 {
    Map<Integer, Map<Character, Integer>> labelMap = new HashMap<>();
    Map<Integer, List<Integer>> child = new HashMap<>();
    public int[] countSubTrees(int n, int[][] edges, String labels) {

        for (int i = 0; i < n; i++) {
            child.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int root = edges[i][0];
            int chlid = edges[i][1];
            child.get(root).add(chlid);
            child.get(chlid).add(root);
        }
        System.out.println(child);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> children = child.getOrDefault(i, new ArrayList<>());
            for (int j = 0; j < children.size(); j++) {
                getLabelMap(i,j,labels);
            }
            res[i] = labelMap.get(i).getOrDefault(labels.charAt(i), 0);
        }
        return res;
    }
    public Map<Character, Integer> getLabelMap(int root, int parent, String labels) {
        if (labelMap.containsKey(root)) {
            return labelMap.get(root);
        }
        Map<Character, Integer> labelsMap = new HashMap<>();
        List<Integer> children = child.getOrDefault(root, new ArrayList<>());
        labelsMap.put(labels.charAt(root), 1);
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i) == parent) {
                continue;
            }
            Map<Character, Integer> childLabelMap = getLabelMap(children.get(i), root, labels);
            childLabelMap.forEach((key, value) -> {
                labelsMap.put(key, labelsMap.getOrDefault(key, 0) + value);
            });
        }
        labelMap.put(root, labelsMap);
        System.out.println(labelMap);
        return labelsMap;
    }
}
