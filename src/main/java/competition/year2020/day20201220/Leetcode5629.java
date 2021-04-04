package competition.year2020.day20201220;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201220
 * @ClassName: Leetcode5629
 * @Author: markey
 * @Description:
 * @Date: 2020/12/20 10:30
 * @Version: 1.0
 */
public class Leetcode5629 {
    public String reformatNumber(String number) {
        List<String> res = new ArrayList<>();
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                newString.append(number.charAt(i));
            }
        }
        for (int i = 0; i < newString.length(); i += 3) {
            if (newString.length() - i <= 4) {
                if (newString.length() - i <= 3) {
                    res.add(newString.substring(i, newString.length()));
                } else {
                    res.add(newString.substring(i, i + 2));
                    res.add(newString.substring(i + 2, newString.length()));
                }
                break;
            }
            res.add(newString.substring(i, i + 3));
        }
        return res.stream().map(String::valueOf).collect(Collectors.joining("-"));
    }
}
