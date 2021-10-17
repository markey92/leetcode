package competition.year2021.day20210725;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210725
 * @ClassName: Leetcode5824
 * @Author: markey
 * @Description:
 * @Date: 2021/7/25 10:45
 * @Version: 1.0
 */
public class Leetcode5824 {
    public String maximumNumber(String num, int[] change) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, -1);
        }
        for (int i = 0; i < change.length; i++) {
            if (change[i] > map.get(i)) {
                map.put(i, change[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean hasChange = false;
        for (int i = 0; i < num.length();) {
            if (!hasChange && map.get(num.charAt(i) - '0') > num.charAt(i)  - '0') {
                while (i < num.length() && map.get(num.charAt(i) - '0') >= num.charAt(i)  - '0') {
                    stringBuilder.append(map.get(num.charAt(i)  - '0'));
                    i++;
                }
                hasChange = true;
            } else {
                stringBuilder.append(num.charAt(i));
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
