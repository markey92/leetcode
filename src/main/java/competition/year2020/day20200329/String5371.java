package competition.year2020.day20200329;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200329
 * @ClassName: String5371
 * @Author: markey
 * @Description:
 * @Date: 2020/3/29 11:36
 * @Version: 1.0
 */
public class String5371 {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        return findGoodStrings("", s1, s2, evil);
    }

    private int findGoodStrings(String base, String s1, String s2, String evil) {
        int baseLength = base.length();
        if (baseLength == s1.length()) {
            return 1;
        }

        if (base.length() >= evil.length() && base.contains(evil)) {
            return 0;
        }
        int res = 0;
        char startChar = s1.startsWith(base) ? s1.charAt(baseLength) : 'a';
        char endChar = s2.startsWith(base) ? s2.charAt(baseLength) : 'z';

        char evilChar = evil.charAt(evil.length() - 1);
        for (char i = startChar; i <= endChar ; i++) {
            String newBase = base + i;
//            System.out.println(newBase);
            if (base.length() < evil.length() || i != evilChar) {
                res += findGoodStrings(newBase, s1, s2, evil);
            }
        }
        return res;
    }
}
