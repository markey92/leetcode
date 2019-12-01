package greedy;

import java.util.Arrays;

public class Greedy455 {
    /**
     * 思想：每个小孩匹配和他一样大或者大一点的饼干，可以使得吃饱的小孩最多
     * 将小孩和饼干从小到大排序，每个小孩匹配和他一样大或者大一点的饼干，如果没有饼干了，说明剩下的小孩都没法吃饱。
     * Runtime: 8 ms, faster than 98.42% of Java online submissions for Assign Cookies.
     * Memory Usage: 40 MB, less than 100.00% of Java online submissions for Assign Cookies.
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = 0;
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            while (sIndex < s.length && s[sIndex] < g[i]) {
                sIndex ++;
            }
            if (sIndex < s.length) {
                sIndex ++;
                res ++;
            } else {
                break;
            }
        }
        return res;
    }
}
