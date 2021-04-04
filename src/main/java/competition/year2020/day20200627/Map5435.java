package competition.year2020.day20200627;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200627
 * @ClassName: Map5435
 * @Author: markey
 * @Description:
 * @Date: 2020/6/27 22:56
 * @Version: 1.0
 */
public class Map5435 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        // 假设第一学期可以选修所有课程
        List<Integer> can = new ArrayList<>();
        List<Integer> not = new ArrayList<>(); // 不能选修的课程
        for (int i = 1; i <= n; i++) {
            can.add(i);
        }

//        Map<Integer, List<Integer>> nextSession = new HashMap<>();
        Map<Integer, List<Integer>> dependency = new HashMap<>();

        for (int i = 0; i < dependencies.length; i++) {
            int now = dependencies[i][0];
            int next = dependencies[i][1];
//            if (!nextSession.containsKey(now)) {
//                nextSession.put(now, new ArrayList<>());
//            }
//            nextSession.get(now).add(next);

            if (!dependency.containsKey(next)) {
                dependency.put(next, new ArrayList<>());
            }
            dependency.get(next).add(now);
            if (can.contains(next)) {
                // 不能在第一学期选修了
                can.remove(can.indexOf(next));
                not.add(next);
            }
        }
        System.out.println(dependency);
        System.out.println(can);
        System.out.println(not);
        // 从可以选修的课程里取出k个作为第一学期课程
        List<Integer> had = new ArrayList<>();
        int sum = 0;
        while (had.size() < n) {
            sum += 1;
            System.out.println("学期" + sum);

            if (can.size() < k) {
                can = findCan(had, can, not, dependency);
            }
            System.out.println("can" + can);
            int size = Math.min(k, can.size());
            had.addAll(can.subList(0, size));
            can = can.subList(size, can.size());
            System.out.println("had" + had);
            System.out.println("can" + can);
        }
        return sum;
    }

    /**
     *
     * @param had 已修
     * @param can 可以选修
     * @param not 未选修
     * @param dependency
     * @return
     */
    private List<Integer> findCan(List<Integer> had,List<Integer> can,  List<Integer> not, Map<Integer, List<Integer>> dependency) {
        Iterator<Integer> iterator = not.iterator();
        while (iterator.hasNext()) {
            int lession = iterator.next();
            if (!dependency.containsKey(lession)) {
                // 没有依赖，现在可以选修
                can.add(lession);
                continue;
            }
            // 判断是否依赖的都在had里
            boolean ok = true;
            List<Integer> dependencies = dependency.get(lession);
            for (int j = 0; j < dependencies.size(); j++) {
                if (!had.contains(dependencies.get(j))) {
                    // 未满足选修要求
                    ok = false;
                    break;
                }
            }
            if (ok) {
                dependency.remove(lession);
                iterator.remove();
                can.add(lession);
            }
        }
        return can;
    }
}
