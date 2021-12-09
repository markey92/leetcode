package competition.day20211024;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211024
 * @ClassName: Leetcode5909
 * @Author: markey
 * @Description:
 * @Date: 2021/10/24 12:53
 * @Version: 1.0
 */
public class Leetcode5909 {
    public static void main(String[] args) {
        Leetcode5909 leetcode5909 = new Leetcode5909();
        leetcode5909.minimumTime(3, new int[][] {{1,3},{2,3}}, new int[]{3,2,5});
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> preClazzs = new HashMap<>();
        for (int i = 0; i < relations.length; i++) {
            int prevCourse = relations[i][0] - 1;  // 课程是从1开始的
            int nextCourse = relations[i][1] - 1;  // 课程是从1开始的
            if (!preClazzs.containsKey(nextCourse)) {
                preClazzs.put(nextCourse, new ArrayList<>());
            }
            preClazzs.get(nextCourse).add(prevCourse);
        }
        System.out.println(preClazzs);

        int[] lastTime = new int[n];
        Arrays.fill(lastTime, -1);
        for (int i = 0; i < n; i++) {
            time(preClazzs, lastTime, time, i);
        }
        System.out.println(Arrays.toString(lastTime));
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, lastTime[i]);
        }
        return res;
    }

    private void time(Map<Integer, List<Integer>> preClazzs, int[] lastTime, int[] time, int clazz) {
        int preTime = 0;
        if (preClazzs.containsKey(clazz)) {
            for (int preClass : preClazzs.get(clazz)) {
                if (lastTime[preClass] == -1) {
                    time(preClazzs, lastTime, time, preClass);
                }
                preTime = Math.max(preTime, lastTime[preClass]);
            }
        }
        lastTime[clazz] = preTime + time[clazz];
    }
}
