package competition.year2020.day20200216;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200216
 * @ClassName: Num5341
 * @Author: markey
 * @Description:
 * @Date: 2020/2/16 10:36
 * @Version: 1.0
 */
public class Num5341 {
    class ProductOfNumbers {

        List<Integer> list;
        public ProductOfNumbers() {
            list = new ArrayList<>();
        }

        public void add(int num) {
            list.add(num);
        }

        public int getProduct(int k) {
            if (k < 0) return 0;
            int res = 1;
            for (int i = 1; i <= k; i++) {
                res *= list.get(list.size() - i);
            }
            return res;
        }
    }

}
