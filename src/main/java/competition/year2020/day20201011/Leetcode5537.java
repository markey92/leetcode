package competition.year2020.day20201011;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201011
 * @ClassName: Leetcode5537
 * @Author: markey
 * @Description:
 * @Date: 2020/10/11 10:47
 * @Version: 1.0
 */
public class Leetcode5537 {
    public boolean checkPalindromeFormation(String a, String b) {
        return checkString(a, b) || checkString(b, a);
    }
    public boolean checkString(String a, String b) {
        if (a.length() == 1 && b.length() == 1) {
            return true;
        }
        int split = 0;
        for (split = 0; split < a.length(); split++) {
            if (a.charAt(split) != b.charAt(b.length() - split - 1)) {
                break;
            }
        }
        boolean result = checkString(a, split, a.length() - split - 1) || checkString(b, split, b.length() - split - 1);
        return result;
    }

    private boolean checkString(String a, int start, int end) {
        while (start < end) {
            if (a.charAt(start) != a.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
