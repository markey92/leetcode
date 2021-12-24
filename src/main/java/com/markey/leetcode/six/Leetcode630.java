package com.markey.leetcode.six;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.six
 * @ClassName: Leetcode630
 * @Author: markey
 * @Description:
 * @Date: 2021/12/14 21:42
 * @Version: 1.0
 */
public class Leetcode630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> courseCost = new PriorityQueue<>(Comparator.reverseOrder());
        int lastTime = 0;
        for (int i = 0; i < courses.length; i++) {
            int[] course = courses[i];
            if (lastTime + course[0] > course[1]) {
                // 不能学完这个课程，找到前面一个最长时间的课程弃学，然后学这个
                if (!courseCost.isEmpty() && courseCost.peek() > course[0]) {
                    lastTime -= courseCost.poll();
                    lastTime += course[0];
                    courseCost.add(course[0]);
                }
            } else {
                lastTime += course[0];
                courseCost.add(course[0]);
            }
        }
        return courseCost.size();
    }
}
