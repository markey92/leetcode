package com.markey.leetcode.two;

import utils.ListNode;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.two
 * @ClassName: Leetcode207
 * @Author: markey
 * @Description:
 * @Date: 2021/3/10 19:01
 * @Version: 1.0
 */
public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> necessary = new HashMap<>();
        int[] need = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (!necessary.containsKey(prerequisites[i][1])) {
                necessary.put(prerequisites[i][1], new ArrayList<>());
            }
            necessary.get(prerequisites[i][1]).add(prerequisites[i][0]); // 学习[i][1]之后可能可以学习[i][0]
            need[prerequisites[i][0]]++; // 学习[i][0]之前需要先学习的课程数
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (need[i] == 0) {
                // 这是没有前置课程，可以直接学习
                queue.add(i);
            }
        }

        int canCount = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> temp = necessary.get(course);
            for (int i = 0; temp != null && i < temp.size(); i++) {
                need[temp.get(i)]--;
                if (need[temp.get(i)] == 0) {
                    // 前置课程都学完了，可以开始学习了
                    queue.add(temp.get(i));
                }
            }
            for (int x: necessary.get(course)) {
                need[x]--;
                if (need[x] == 0) {
                    // 前置课程都学完了，可以开始学习了
                    queue.add(x);
                }
            }
            canCount++;
        }
        return canCount == numCourses;
    }
}
