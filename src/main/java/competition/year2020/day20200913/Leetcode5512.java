package competition.year2020.day20200913;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200913
 * @ClassName: Leetcode5512
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 10:35
 * @Version: 1.0
 */
public class Leetcode5512 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] pair = new int[n];
        for (int i = 0; i < pairs.length; i++) {
            int[] temp = pairs[i];
            pair[temp[0]] = temp[1];
            pair[temp[1]] = temp[0];
        }

        int count = 0;
        for (int x = 0; x < n; x++) {
            int y = pair[x];
            int[] preference = preferences[x];
            for (int j = 0; j < preference.length; j++) {
                int u = preference[j];
                if (u == y) {
                    break;
                }
                int v = pair[u];
                if (check(preferences[u], x, v)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private boolean check(int[] preference, int x, int v) {
        for (int i = 0; i < preference.length; i++) {
            if (preference[i] == x) {
                return true;
            }
            if (preference[i] == v) {
                return false;
            }
        }
        return false;
    }
}
