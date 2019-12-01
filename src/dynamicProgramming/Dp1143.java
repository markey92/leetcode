package dynamicProgramming;

public class Dp1143 {
    /**
     * Runtime: 7 ms, faster than 88.14% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Longest Common Subsequence.
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int[][] nums = new int[text1.length()][text2.length()];
        nums[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < text1.length(); i++) {
            nums[i][0] = text1.charAt(i) == text2.charAt(0) || nums[i-1][0] == 1 ? 1 : 0;
        }
        for (int i = 1; i < text2.length(); i++) {
            nums[0][i] = text1.charAt(0) == text2.charAt(i) || nums[0][i-1] == 1 ? 1 : 0;
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    nums[i][j] = nums[i-1][j-1] + 1;
                } else {
                    nums[i][j] = Math.max(nums[i-1][j], nums[i][j-1]);
                }
            }
        }
        return nums[text1.length()-1][text2.length()-1];
    }
}
