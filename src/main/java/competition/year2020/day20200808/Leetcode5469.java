package competition.year2020.day20200808;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200808
 * @ClassName: Leetcode5469
 * @Author: markey
 * @Description:
 * @Date: 2020/8/8 22:38
 * @Version: 1.0
 */
public class Leetcode5469 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] num = new int[27];
        for (int i = 0; i < s.length(); i++) {
            int temp = (26 + t.charAt(i) - s.charAt(i)) % 26;
            if (num[temp] > 0) {
                num[temp] = num[temp] + 26;
            } else {
                num[temp] = temp;
            }
            if (num[temp] > k) {
                return false;
            }
        }

        return true;
    }
}
