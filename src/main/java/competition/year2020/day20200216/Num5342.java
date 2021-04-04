package competition.year2020.day20200216;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200216
 * @ClassName: Num5342
 * @Author: markey
 * @Description:
 * @Date: 2020/2/16 10:43
 * @Version: 1.0
 */
public class Num5342 {
    public static void main(String[] args) {
//        System.out.println(maxEvents(new int[][] {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}}));
//        System.out.println(maxEvents(new int[][] {{1,2},{2,3},{3,4},{1,2}}));
        System.out.println(maxEvents(new int[][] {{26,27},{24,26},{1,4},{1,2},{3,6},{2,6},{9,13},{6,6},{25,27},{22,25},{20,24},{8,8},{27,27},{30,32}}));
    }
    public static int maxEvents(int[][] events) {
        List<int[]> meetings = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            meetings.add(events[i]);
            if (max < events[i][1]) {
                max = events[i][1];
            }
        }
        int[] days = new int[max + 1];
        while (!meetings.isEmpty()) {
            int[] meeting = meetings.get(0);
            int start = meeting[0];
            int end = meeting[1];
            System.out.println(meeting[0] + " " + meeting[1]);
            if (days[start] == 0) {
                days[start] = end;
            } else {
                if (days[start] > end && (start + 1) <= days[start]) {
                    meetings.add(new int[] {start + 1, days[start]});
                    System.out.println("add meeting:" + (start + 1) + " " + days[start]);
                    days[start] = end;
                } else if (days[start] <= end && (start + 1) <= end) {
                    System.out.println("add meeting:" + (start + 1) + " " + end);
                    meetings.add(new int[] {start + 1, end});
                }
            }
            System.out.println("remove meeting:" + start + " " + end);
            meetings.remove(meeting);
        }
        int count = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] != 0) {
                count++;
            }
            System.out.print(" " + days[i]);
        }
        System.out.println();
        return count;
    }
}
