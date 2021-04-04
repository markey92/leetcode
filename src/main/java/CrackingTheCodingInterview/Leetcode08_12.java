package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_12
 * @Author: markey
 * @Description:
 * @Date: 2020/9/29 20:40
 * @Version: 1.0
 */
public class Leetcode08_12 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] local = new int[n];
        solveNQueens(local, new ArrayList<>(), res);
        return res;
    }

    public void solveNQueens(int[] local, List<List<Character>> parent, List<List<String>> res) {
        int n = local.length;
        if (parent.size() == n) {
            // 结束条件
            List<String> end = new ArrayList<>();
            for (int i = 0; i < parent.size(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < parent.get(i).size(); j++) {
                    sb.append(parent.get(i).get(j));
                }
                end.add(sb.toString());
            }
            res.add(end);
        }
        for (int i = 0; i < n; i++) {
            if (local[i] != 0) {
                // 避免竖向冲突
                continue;
            }
            if (!canLocal(parent, i)) {
                // 避免斜线冲突
                continue;
            }
            // 回溯算法
            local[i] = 1;
            parent.add(getQueue(n, i));
            solveNQueens(local, parent, res);
            parent.remove(parent.size() - 1);
            local[i] = 0;
        }
    }

    // 检查斜对向冲突
    private boolean canLocal(List<List<Character>> parent, int i) {
        int row = parent.size();
        int col = i;
        for (int j = row - 1, k = col - 1; j >= 0 && k >= 0; j--, k--) {
            if (parent.get(j).get(k) == 'Q') {
                return false;
            }
        }
        for (int j = row - 1, k = col + 1; j >= 0 && k < parent.get(j).size(); j--, k++) {
            if (parent.get(j).get(k) == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 获取在某一点放置皇后后的那一行
    private List<Character> getQueue(int n, int local) {
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < local; i++) {
            res.add('.');
        }
        res.add('Q');
        for (int i = local + 1; i < n; i++) {
            res.add('.');
        }
        return res;
    }
}
