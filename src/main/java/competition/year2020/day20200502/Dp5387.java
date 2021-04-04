package competition.year2020.day20200502;

import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200502
 * @ClassName: Dp5387
 * @Author: markey
 * @Description:
 * @Date: 2020/5/2 23:29
 * @Version: 1.0
 */
public class Dp5387 {
    public int numberWays(List<List<Integer>> hats) {
        if (hats.size() == 0) {
            return 0;
        }
        hats.sort(Comparator.comparingInt(List::size));
        System.out.println(hats);
        return (int) (numberWays(hats, 0) % 1000000007);
    }

    private long numberWays(List<List<Integer>> hats, long set) {
        long res = 0;
        if (hats.size() == 1) {
            List<Integer> likeHats = hats.get(0);
            for (int i = 0; i < likeHats.size(); i++) {
                int likeHat = likeHats.get(i);
                res += (((1 << likeHat) & set) > 0)? 0 : 1;
            }
        } else {
            List<Integer> likeHats = hats.get(0);
            for (int i = 0; i < likeHats.size(); i++) {
                int likeHat = likeHats.get(i);
                if (((1 << likeHat) & set) > 0) {
                    continue;
                }
                set = set | (1 << likeHat);
                hats.remove(0);
                res += numberWays(hats, set);
                hats.add(0, likeHats);
                set = set ^ (1 << likeHat);
            }
        }
        return res;
    }
}
