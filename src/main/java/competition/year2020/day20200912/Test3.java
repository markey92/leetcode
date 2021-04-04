package competition.year2020.day20200912;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200912
 * @ClassName: Test3
 * @Author: markey
 * @Description:
 * @Date: 2020/9/12 15:15
 * @Version: 1.0
 */
public class Test3 {
    public int minimumOperations(String leaves) {
        int res = 0;
        int n = leaves.length();
        if (leaves.charAt(0) == 'y') {
            res++;
        }
        if (leaves.charAt(n - 1) == 'y') {
            res++;
        }
        int start = 1;
        while (start < n && leaves.charAt(start) == 'r') {
            start++;
        }
        int end = n - 2;
        while (end >= 0 && leaves.charAt(end) == 'r') {
            end--;
        }
        // 中间全部是r的情况
        if (start > end) {
            return res + 1;
        }

        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = start + 1; i <= end; i++) {
            if (leaves.charAt(i) == leaves.charAt(i - 1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        System.out.println(list);
        if (list.size() == 1) {
            return res;
        } else if (list.size() == 2) {
            return res + Math.min(list.get(0), list.get(1));
        } else if (list.size() == 3) {
            return res + list.stream().min(Integer::compareTo).get();
        } else if (list.size() == 4) {
            return res + Math.min(list.get(1), list.get(2));
        } else if (list.size() == 5) {
            return res + Math.min(list.get(0), list.get(1)) + Math.min(list.get(3), list.get(4));
        } else {
            int middle = list.size() / 2;
            int tempR = 0;
            int tempY = 0;
            for (int i = 0; i < middle; i += 2) {
                tempY += list.get(i);
                tempR += list.get(i + 1);
            }
            res += Math.min(tempR, tempY);
            tempR = 0;
            tempY = 0;
            for (int i = middle + 1; i < list.size(); i += 2) {
                tempR += list.get(i);
                tempY += list.get(i + 1);
            }
            res += Math.min(tempR, tempY);
        }
        return res;
    }
}
