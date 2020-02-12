package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF58_2
 * @Author: markey
 * @Description:
 * @Date: 2020/2/12 23:19
 * @Version: 1.0
 */
public class LCOF58_2 {
    public String reverseLeftWords(String s, int n) {
        String res = s.substring(n);
        res += s.substring(0, n);
        return res;
    }
}
