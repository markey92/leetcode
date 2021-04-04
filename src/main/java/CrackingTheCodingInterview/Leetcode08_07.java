package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_07
 * @Author: markey
 * @Description:
 * @Date: 2020/9/26 23:47
 * @Version: 1.0
 */
public class Leetcode08_07 {
    public String[] permutation(String S) {
        return permutation(new StringBuilder(S));
    }
    public String[] permutation(StringBuilder S) {
        if (S.length() == 0) {
            return new String[] {""};
        }
        // 回溯算法
        List<String> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            S.deleteCharAt(i);
            String[] resTemp = permutation(S);
            for (int j = 0; j < resTemp.length; j++) {
                res.add(temp + resTemp[j]);
            }
            S.insert(i, temp);
        }
        return res.toArray(new String[res.size()]);
    }

}
