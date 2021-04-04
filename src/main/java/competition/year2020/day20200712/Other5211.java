package competition.year2020.day20200712;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200712
 * @ClassName: Other5211
 * @Author: markey
 * @Description:
 * @Date: 2020/7/12 10:44
 * @Version: 1.0
 */
public class Other5211 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> nextNode = new HashMap<>(); // 每个节点可以到达的下一个节点
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (!nextNode.containsKey(from)) {
                nextNode.put( from, new ArrayList<>());
            }
            if (!nextNode.containsKey(to)) {
                nextNode.put( to, new ArrayList<>());
            }
            nextNode.get(from).add(new double[] {to, succProb[i]});
            nextNode.get(to).add(new double[] {from, succProb[i]});
        }

        // 开始DFS
        Map<Double, Double> probabilityMap = new HashMap<>(); // 记录达到每个节点的可能性
        Deque<double[]> deque = new LinkedList<>();
        deque.add(new double[] {start, 1});
        // System.out.println(probabilityMap);
        while (deque.size() != 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                double[] newNode = deque.pollFirst();
                // System.out.println("newNode" + Arrays.toString(newNode));
                if (probabilityMap.containsKey(newNode[0]) && probabilityMap.get(newNode[0]) >= newNode[1]) {
                    // 可能性没有变大，不需要再测算概率
                    continue;
                }

                if (probabilityMap.getOrDefault(newNode[0], 0.0) < newNode[1]) {
                    probabilityMap.put(newNode[0], newNode[1]);
                }
                // 需要重新测算概率的节点
                List<double[]> nextNodeList = nextNode.getOrDefault((int)newNode[0], Collections.emptyList());
                for (int j = 0; j < nextNodeList.size(); j++) {
                    deque.addLast(new double[] {nextNodeList.get(j)[0], nextNodeList.get(j)[1] * newNode[1]});
                }
            }
            // System.out.println(probabilityMap);
        }
        return probabilityMap.getOrDefault((double)end, 0.0);
    }
}
