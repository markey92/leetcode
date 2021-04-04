package competition.day20210228;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210228
 * @ClassName: Leetcode5689
 * @Author: markey
 * @Description:
 * @Date: 2021/2/28 10:30
 * @Version: 1.0
 */
public class Leetcode5689 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        switch (ruleKey) {
            case "type" : index = 0; break;
            case "color" : index = 1; break;
            default: index = 2;
        }
        int res = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(index).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
