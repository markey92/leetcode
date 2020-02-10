package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Db
 * @Author: markey
 * @Description:
 * @Date: 2020/2/9 11:39
 * @Version: 1.0
 */
public class Db5335 {
//    public int maxStudents(char[][] seats) {
//        int[][] sit = new int[seats.length][seats[0].length];
//        int[][] noSit = new int[seats.length][seats[0].length];
//        if (seats[0][0] == '#') {
//            sit[0][0] = 0;
//            noSit[0][0] = 0;
//        } else {
//            sit[0][0] = 1;
//            noSit[0][0] = 0;
//        }
//        for (int i = 1; i < seats[0].length; i++) {
//            if (seats[0][i] == '#') {
//                sit[0][i] = sit[0][i-1];
//                noSit[0][i] = noSit[0][i-1];
//                continue;
//            }
//            if (seats[0][i-1] == '#') {
//                sit[0][i] = sit[0][i-1] + 1;
//                noSit[0][i] = noSit[0][i-1];
//            } else {
//                sit[0][i] = noSit[0][i-1] + 1;
//                noSit[0][i] = sit[0][i-1];
//            }
//        }
//
//        for (int i = 1; i < seats.length; i++) {
//            if (seats[i][0] == '#') {
//                sit[i][0] = sit[i-1][0];
//                noSit[i][0] = sit[i-1][0];
//                continue;
//            }
//            sit[0][i] = sit[0][i-1] + 1;
//            noSit[0][i] = sit[0][i-1];
//        }
//
//        for (int i = 0; i < seats.length; i++) {
//            for (int j = 0; j < seats[i].length; j++) {
//                if (seats[i][j] == '#') {
//                    sit[i][j] = Math.max(sit[i-1][j], sit[i][j-1]);
//                    noSit[0][i] = Math.max(sit[i-1][j], sit[i][j-1]);
//                    continue;
//                }
//                if (seats[i-1][j] == '#') {
//                    sit[0][i] = Math.max(sit[i-]);
//                    noSit[0][i] = noSit[0][i-1];
//                } else {
//                    sit[0][i] = noSit[0][i-1] + 1;
//                    noSit[0][i] = sit[0][i-1];
//                }
//            }
//        }
//    }

}
