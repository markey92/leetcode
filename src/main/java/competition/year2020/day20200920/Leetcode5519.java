package competition.year2020.day20200920;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200920
 * @ClassName: Leetcode5519
 * @Author: markey
 * @Description:
 * @Date: 2020/9/20 10:31
 * @Version: 1.0
 */
public class Leetcode5519 {
    public String reorderSpaces(String text) {
        int count = 0;
        List<String> stringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            } else {
                sb.append(text.charAt(i));
                continue;
            }
            if (sb.length() != 0) {
                stringList.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        if (sb.length() != 0) {
            stringList.add(sb.toString());
        }
        int countPre = stringList.size() == 1 ? 0 : count / (stringList.size() - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            res.append(stringList.get(i));
            for (int j = 0; i != stringList.size() - 1 && j < countPre; j++) {
                res.append(" ");
                count -= 1;
            }
        }
        for (int i = 0; i < count; i++) {
            res.append(" ");
        }
        return res.toString();
    }
}
