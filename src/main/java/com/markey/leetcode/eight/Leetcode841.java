package com.markey.leetcode.eight;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.eight
 * @ClassName: Leetcode841
 * @Author: markey
 * @Description:
 * @Date: 2021/3/9 21:57
 * @Version: 1.0
 */
public class Leetcode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> hadReach = new HashSet<>();
        Deque<Integer> canReach = new LinkedList<>();
        canReach.add(0);
        while (!canReach.isEmpty()) {
            int x = canReach.poll();
            if (!hadReach.contains(x)) {
                hadReach.add(x);
                canReach.addAll(rooms.get(x));
            }
        }
        return hadReach.size() == rooms.size();
    }
}
