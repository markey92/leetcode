package competition.day20200321;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200321
 * @ClassName: Array5349
 * @Author: markey
 * @Description:
 * @Date: 2020/3/21 22:56
 * @Version: 1.0
 */
public class Array5349 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            if (!map.containsKey(reservedSeats[i][0])) {
                map.put(reservedSeats[i][0], new ArrayList<>());
            }
            map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
        }
        System.out.println(map);
        int count = 0;
        for (int key: map.keySet()) {
            int[] seats = new int[11];
            ArrayList<Integer> list = map.get(key);
            for (int j: list) {
                seats[j] = 1;
            }
            System.out.println(Arrays.toString(seats));
            count += match(seats);
        }
        count += (n - map.size()) * 2;
        return count;
    }

    private int match(int[] seats) {
        int count = 0;
        boolean firstSeat = true;
        for (int i = 2; i <= 5; i++) {
            if (seats[i] == 1) {
                firstSeat = false;
            }
        }
        if (firstSeat) {
            count++;
        }
        boolean secondSeat = true;
        for (int i = 6; i <= 9; i++) {
            if (seats[i] == 1) {
                secondSeat = false;
            }
        }
        if (secondSeat) {
            count++;
        }
        if (count == 0) {
            boolean thirdSeat = true;
            for (int i = 4; i <= 7; i++) {
                if (seats[i] == 1) {
                    thirdSeat = false;
                }
            }
            if (thirdSeat) {
                count++;
            }
        }
        return count;
    }
}
