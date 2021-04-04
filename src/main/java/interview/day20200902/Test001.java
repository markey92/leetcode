package interview.day20200902;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20200902
 * @ClassName: Test001
 * @Author: markey
 * @Description:
 * @Date: 2020/9/2 20:06
 * @Version: 1.0
 */
public class Test001 {
    class ProductOfNumbers {
        private int[] products;
        private int index;
        public ProductOfNumbers() {
            this.index = -1;
            this.products = new int[40000];
        }

        public void add(int num) {
            index++;
            this.products[index] = num;
        }

        public int getProduct(int k) {

            int res = 1;
            for (int i = 0; i < k; i++) {
                res = res * this.products[index - i];
            }
            return res;
        }
    }
}
