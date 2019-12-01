package dynamicProgramming;

public class Dp392 {
    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            dp[0][i] = s.charAt(0) == t.charAt(i) || dp[0][i-1];
        }

        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()-1][t.length()-1];
    }
    /**
     * Runtime: 17 ms, faster than 46.85% of Java online submissions for Is Subsequence.
     * Memory Usage: 48.2 MB, less than 100.00% of Java online submissions for Is Subsequence.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0, tIndex;
        for (tIndex = 0; sIndex < s.length() && tIndex < t.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex ++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }
}
