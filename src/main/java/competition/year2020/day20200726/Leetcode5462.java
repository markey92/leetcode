package competition.year2020.day20200726;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200726
 * @ClassName: Leetcode5462
 * @Author: markey
 * @Description:
 * @Date: 2020/7/26 11:03
 * @Version: 1.0
 */
public class Leetcode5462 {
    public int getLengthOfOptimalCompression(String s, int k) {
        // 统计字符
        List<int[]> list = new ArrayList<>();
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                list.add(new int[] {s.charAt(i - 1) - 'a',  temp});
                temp = 1;
            } else {
                temp++;
            }
        }
        list.add(new int[] {s.charAt(s.length() - 1) - 'a', temp});

        // 按字符多少排序
        List<int[]> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        sortedList.sort(Comparator.comparingInt(a -> a[1]));

        // 优先删除可以完全删掉的字符
        int count = 0;
        for (int i = 0; i < sortedList.size(); i++) {
            if (k - sortedList.get(i)[1] >= 0) {
                k -= sortedList.get(i)[1];
                count++;
            } else {
                break;
            }
        }
        System.out.println(sortedList);
        System.out.println(count);

        // 合并字符
        List<int[]> list1 = new ArrayList<>();
        temp = sortedList.get(count)[1];
        for (int i = count + 1; i < sortedList.size(); i++) {
            if (sortedList.get(i)[0] != sortedList.get(i - 1)[0]) {
                list1.add(new int[] {sortedList.get(i - 1)[0],  temp});
                temp = sortedList.get(i)[1];
            } else {
                temp += sortedList.get(i)[1];
            }
        }
        list1.add(new int[] {sortedList.get(sortedList.size() - 1)[0], temp});
        list1.forEach(a -> System.out.println(Arrays.toString(a)));

        // 找到可以减少位数的数字
        for (int i = 0; i < list1.size(); i++) {
            if ((list1.get(i)[1] - k) % 10 == 9 || list1.get(i)[1] - k == 1) {
                list1.set(i, new int[] {list1.get(i)[0], list1.get(i)[1] - k});
            }
        }

        // 统计结果
        int res = 0;
        for (int i = 0; i < list1.size(); i++) {
            res += 1;
            if (list1.get(i)[1] > 1) {
                res += String.valueOf(list1.get(i)[1]).length();
            }
        }
        return res;
    }
}
