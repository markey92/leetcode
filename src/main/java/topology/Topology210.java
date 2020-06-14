package topology;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: topology
 * @ClassName: Topology210
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 16:52
 * @Version: 1.0
 */
public class Topology210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 找不不依赖其他课程的开始课程；
        List<Integer> cources = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            cources.add(i);
        }

        Map<Integer, List<Integer>> depency = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            // 去掉需要依赖其他课程的
            if (cources.contains(prerequisites[i][0])) {
                cources.remove(cources.indexOf(prerequisites[i][0]));
            }
            // 记录依赖关系
            if (depency.containsKey(prerequisites[i][0])) {
                depency.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                depency.put(prerequisites[i][0], list);
            }
        }
        // 如果所有课程都依赖其他课程，则无解
        if (cources.size() == 0) {
            return new int[]{};
        }
        // 否则可以开始不断加入可以学习的课程
        // map中存的是依赖其他课程的课程
        while (!depency.isEmpty()) {
            int numOfdepency = depency.size();
            Iterator<Integer> iterator = depency.keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                if (isHasDepency(cources, depency.get(key))) {
                    iterator.remove();
                    cources.add(key);
                }
            }
            if (numOfdepency == depency.size()) {
                // 所有这次循环没有找到可以继续学习的课程,下次循环的结果是一样的，不需要再循环了
                break;
            }
        }
        if (depency.isEmpty()) {
            return cources.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[]{};
        }
    }

    private boolean isHasDepency(List<Integer> cources, List<Integer> depencies) {
        if (cources.size() < depencies.size()) {
            return false;
        }
        for (int i = 0; i < depencies.size(); i++) {
            if (!cources.contains(depencies.get(i))) {
                return false;
            }
        }
        return true;
    }
}
