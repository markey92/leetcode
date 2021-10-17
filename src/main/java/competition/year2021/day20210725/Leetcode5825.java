package competition.year2021.day20210725;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210725
 * @ClassName: Leetcode5825
 * @Author: markey
 * @Description:
 * @Date: 2021/7/25 11:14
 * @Version: 1.0
 */
public class Leetcode5825 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        Set<Integer> mentorInts = new HashSet<>();
        for (int i = 0; i < mentors.length; i++) {
            mentorInts.add(bit(mentors[i]));
        }

        Set<Integer> studentInts = new HashSet<>();
        for (int i = 0; i < students.length; i++) {
            studentInts.add(bit(students[i]));
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            deque.addAll(studentInts);
        }

        int res = 0;
        for (int i = n; i > 0; i--) {
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                int stu = deque.pollFirst();
                boolean match = false;
                for (int men : mentorInts) {
                    if ((n - countBit(men ^ stu)) == i) {
                        System.out.println(men + "" + stu);
                        mentorInts.remove(men);
                        match = true;
                        break;

                    }
                }
                if (match) {
                    res += i;
                } else {
                    deque.addLast(stu);
                }
            }
        }
        return res;
    }

    private int bit(int[] y) {
        int x = 0;
        for (int j = 0; j < y.length; j++) {
            x <<= 1;
            x += y[j];
        }
        return x;
    }

    private int countBit(int x) {
        int res = 0;
        while (x > 0) {
            res += x & 1;
            x >>= 1;
        }
        return res;
    }
}
