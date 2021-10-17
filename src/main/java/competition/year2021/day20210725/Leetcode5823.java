package competition.year2021.day20210725;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210725
 * @ClassName: Leetcode5823
 * @Author: markey
 * @Description:
 * @Date: 2021/7/25 10:32
 * @Version: 1.0
 */
public class Leetcode5823 {
    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.append(c - 'a' + 1);
        }
        System.out.println(stringBuilder);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = 0;
            for (int j = 0; j < stringBuilder.length(); j++) {
                res += stringBuilder.charAt(j) - '0';
            }
            System.out.println("res + " + res);
            stringBuilder = new StringBuilder(String.valueOf(res));
        }
        return res;
    }
}
