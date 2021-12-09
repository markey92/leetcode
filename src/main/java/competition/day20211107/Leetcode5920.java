package competition.day20211107;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211107
 * @ClassName: Leetcode5920
 * @Author: markey
 * @Description:
 * @Date: 2021/11/7 11:00
 * @Version: 1.0
 */
public class Leetcode5920 {
    public int minimizedMaximum(int n, int[] quantities) {
        PriorityQueue<Quantity> treeSet = new PriorityQueue<Quantity>((o1, o2) -> o2.getEach() - o1.getEach());
        int count = quantities.length;
        for (int quantity : quantities) {
            treeSet.add(new Quantity(quantity, 1));
        }

        while (count < n) {
            Quantity max = treeSet.poll();
            max.updateCount();
            treeSet.add(max);
            count++;
        }
        System.out.println(treeSet);
        return treeSet.poll().getEach();
    }

    private class Quantity {
        public Quantity(double value, int count) {
            this.value = value;
            this.count = count;
            this.each = (int) Math.ceil(value / count);
        }

        private double value;
        private int count;
        private int each;

        public void updateCount() {
            this.count = this.count + 1;
            this.each =  (int) Math.ceil(this.value / this.count);
        }

        public int getEach() {
            return this.each;
        }

        @Override
        public String toString() {
            return "Quantity{" +
                    "value=" + value +
                    ", count=" + count +
                    ", each=" + each +
                    '}';
        }
    }
}
