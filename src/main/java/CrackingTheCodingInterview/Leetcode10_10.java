package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode10_10
 * @Author: markey
 * @Description:
 * @Date: 2020/10/28 21:55
 * @Version: 1.0
 */
public class Leetcode10_10 {
    class StreamRank {
        List<Integer> list;
        public StreamRank() {
            list = new ArrayList<>();
        }

        public void track(int x) {
            list.add(x);
        }

        public int getRankOfNumber(int x) {
            list.sort(Integer::compareTo);
            return list.lastIndexOf(x) + 1;
        }
    }
}
