package competition.year2020.day20200905;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200905
 * @ClassName: Leetcode5492
 * @Author: markey
 * @Description:
 * @Date: 2020/9/5 22:33
 * @Version: 1.0
 */
public class Leetcode5492 {
    public int numWays(String s) {
        long n = s.length();
        int count = 0;
        int countOfZero = 0;
        List<Long> temp = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                temp.add((long) countOfZero);
                countOfZero = 0;
            } else {
                countOfZero++;
            }
        }
        long res = 0;
        if (count == 0) {
            res = (n - 1) * (n - 2) / 2;
            return (int) (res % 1000000007);
        }

        if (count % 3 != 0) {
            return 0;
        }
        System.out.println(temp);
        res = (temp.get(count / 3) + 1) * (temp.get(count / 3 * 2) + 1);
        return (int) (res % 1000000007);
    }
}
