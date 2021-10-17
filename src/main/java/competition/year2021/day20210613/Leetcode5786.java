package competition.year2021.day20210613;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210613
 * @ClassName: Leetcode5786
 * @Author: markey
 * @Description:
 * @Date: 2021/6/13 10:34
 * @Version: 1.0
 */
public class Leetcode5786 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int start = 0, end = removable.length;
        while (start < end) {
            int mid = (end + start + 1) / 2;
            StringBuilder sb  = subString(s, removable, mid);
            System.out.println(sb);
            if (isResult(sb, p)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private StringBuilder subString(String s, int[] removable, int k) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            indexs.add(removable[i]);
        }
        indexs.sort((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indexs.size(); i++) {
            sb.deleteCharAt(indexs.get(i));
        }
        return sb;
    }

    private boolean isResult(StringBuilder s, String p) {
        int indexP = 0;
        for (int i = 0; i < s.length(); i++) {
            if (indexP < p.length() && s.charAt(i) == p.charAt(indexP)) {
                indexP++;
            }
        }
        return indexP == p.length();
    }
}
