package competition.year2020.day20200315;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200315
 * @ClassName: Stack5357
 * @Author: markey
 * @Description:
 * @Date: 2020/3/15 10:45
 * @Version: 1.0
 */
public class Stack5357 {
    class CustomStack {

        int lastIndex = -1, maxSize = 0;
        List<Integer> list;
        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            list = new ArrayList<>(maxSize);
        }

        public void push(int x) {
            if ((lastIndex + 1) >= maxSize) {
                return;
            }
            list.add(++lastIndex, x);
            System.out.println(list);
        }

        public int pop() {
            if (lastIndex < 0) {
                return -1;
            }
            System.out.println(list);
            return list.remove(lastIndex--);
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i <= lastIndex; i++) {
                int temp = list.remove(i) + val;
                list.add(i, temp);
            }
        }
    }

}
