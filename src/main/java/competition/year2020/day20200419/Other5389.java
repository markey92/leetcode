package competition.year2020.day20200419;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200419
 * @ClassName: Other5389
 * @Author: markey
 * @Description:
 * @Date: 2020/4/19 10:38
 * @Version: 1.0
 */
public class Other5389 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> cai = new TreeSet<>(Comparator.comparingInt(Integer::parseInt));
        TreeMap<String, List<String>> map = new TreeMap<>();
        orders.forEach(order -> {
            cai.add(order.get(2));
            if (!map.containsKey(order.get(1))) {
                map.put(order.get(1), new ArrayList<String>());
            }
            map.get(order.get(1)).add(order.get(2));
        });

        List<List<String>> res = new ArrayList<>();
        List<String> cais = new ArrayList<>(cai);
        res.add(cais);
        for (String key: map.keySet()) {
            List<String> order = new ArrayList<>();
            order.add(key);
            for (int i = 0; i < cais.size(); i++) {
                String y = cais.get(i);
                long count = map.get(key).stream().filter(x -> x.equals(y)).count();
                order.add(String.valueOf(count));
            }
            res.add(order);
        }
        res.get(0).add(0, "Table");
        return res;
    }
    /**
     * [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
     * [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
     *
     * [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
     * [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
     *
     * [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
     * [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
     *
     * [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
     * [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
     */
}
