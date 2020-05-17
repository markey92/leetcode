package competition.day20200517;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200517
 * @ClassName: Sort5413
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 10:33
 * @Version: 1.0
 */
public class Sort5413 {
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        if (arr.length > 0) {
            if (arr[0].length() > 0) {
                arr[0] = (char) (arr[0].charAt(0) + ('a' - 'A')) + arr[0].substring(1);
            }
        }
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i].length();
            if (map.containsKey(n)) {
                map.get(n).add(arr[i]);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(arr[i]);
                map.put(n, strings);
            }
        }
        List<String> res = new ArrayList<>();
        for(Integer key: map.keySet()) {
            res.addAll(map.get(key));
        }
        String result = res.stream().collect(Collectors.joining(" "));
        if (result.length() > 0) {
            result = (char) (result.charAt(0) + ('A' - 'a')) + result.substring(1);
        }
        return result;
    }
}
