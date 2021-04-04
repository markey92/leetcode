package competition.year2020.day20201115;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201115
 * @ClassName: Leetcode5601
 * @Author: markey
 * @Description:
 * @Date: 2020/11/15 10:32
 * @Version: 1.0
 */
public class Leetcode5601 {
    class OrderedStream {
        String[] values;
        int index;
        public OrderedStream(int n) {
            values = new String[n + 1];
            index = 1;
        }

        public List<String> insert(int id, String value) {
            values[id] = value;
            return get();
        }

        private List<String> get() {
            List<String> res = new ArrayList<>();
            while (index < values.length && values[index] != null) {
                res.add(values[index]);
                index++;
            }
            return res;
        }
    }
}
