package interview.day20210424;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210424
 * @ClassName: Test3
 * @Author: markey
 * @Description:
 * @Date: 2021/4/24 10:37
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1,2,3}, {4,0,5}}));
    }
    public static int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String want = "123450";

        List<String> maybe = new ArrayList<>();
        Set<String> exist = new HashSet<>();
        maybe.add(start);
        exist.add(start);
        int res = 0;
        while (!maybe.isEmpty()) {
            int size = maybe.size();
            for (int i = 0; i < size; i++) {
                String status = maybe.remove(0);
                if (want.equals(status)) {
                    return res;
                }
                for (String nextStatus : move(status)) {
                    if (!exist.contains(nextStatus)) {
                        maybe.add(nextStatus);
                        exist.add(nextStatus);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private static List<String> move(String x) {
        // 找出0的位置
        int indexOfZero = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '0') {
                indexOfZero = i;
            }
        }

        // 不同位置可以移动的方式不同，因为只有6中，直接分类处理
        List<String> nextStatus = new ArrayList<>();
        int[] moveDirection = {-1, 1, -3, 3};
        for (int i = 0; i < moveDirection.length; i++) {
            int nextLocation = indexOfZero + moveDirection[i]; // 0的下一个位置
            if (moveDirection[i] == -1 && nextLocation == 2 || moveDirection[i] == 1 && nextLocation == 3) {
                // 特殊情况，会导致换行
                continue;
            }
            if (nextLocation >= 0 && nextLocation < 6) {
                StringBuilder sb = new StringBuilder(x);
                sb.setCharAt(indexOfZero, sb.charAt(nextLocation));
                sb.setCharAt(nextLocation, '0');
                nextStatus.add(sb.toString());
            }
        }
        return nextStatus;
    }
}
