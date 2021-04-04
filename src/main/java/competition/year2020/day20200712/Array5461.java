package competition.year2020.day20200712;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200712
 * @ClassName: Array5461
 * @Author: markey
 * @Description:
 * @Date: 2020/7/12 10:33
 * @Version: 1.0
 */
public class Array5461 {
    public int numSub(String s) {
        long res = 0;
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                oneCount = 0;
            } else {
                oneCount++;
                res += oneCount;
                res %= 1000000007;
            }
        }
        return (int) res;
    }
}
