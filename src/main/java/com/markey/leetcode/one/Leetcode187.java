package com.markey.leetcode.one;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode187
 * @Author: markey
 * @Description:
 * @Date: 2021/10/8 7:55
 * @Version: 1.0
 */
public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        StringBuilder stringBuilder = new StringBuilder(s.subSequence(0, 10));
        Set<String> exist = new HashSet<>();
        exist.add(stringBuilder.toString());

        Set<String> res = new HashSet<>();
        for (int i = 10; i < s.length(); i++) {
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(s.charAt(i));
            if (exist.contains(stringBuilder.toString())) {
                res.add(stringBuilder.toString());
            }
            exist.add(stringBuilder.toString());
        }
        return new ArrayList<>(res);
    }
}
