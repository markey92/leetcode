package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String942
 * @Author: markey
 * @Description:
 * @Date: 2020/2/5 22:29
 * @Version: 1.0
 */
public class String942 {
    public int[] diStringMatch(String S) {
        int max = S.length();
        int min = 0;
        int[] res = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = min;
                min++;
            } else {
                res[i] = max;
                max--;
            }
        }
        res[S.length()] = max;
        return res;
    }
}
