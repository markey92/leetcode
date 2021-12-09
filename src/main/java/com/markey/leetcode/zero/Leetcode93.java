package com.markey.leetcode.zero;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.zero
 * @ClassName: Leetcode93
 * @Author: markey
 * @Description:
 * @Date: 2021/10/23 18:10
 * @Version: 1.0
 */
public class Leetcode93 {
    int[] segments = new int[4];
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int segId, int segStart) {
        // 找齐四段了
        if (segId == 4) {
            if (segStart == s.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    stringBuilder.append(segments[i]);
                    if (i < 3) {
                        stringBuilder.append(".");
                    }
                }
                res.add(stringBuilder.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            // 未找齐4段，但是没有多余字符了
            return;
        }

        if (s.charAt(segStart) == '0') {
            // 前导0规格，这一段只能是0；
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 枚举每一种可能
        int num = 0;
        for (int i = segStart; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 0 && num <= 255) {
                segments[segId] = num;
                dfs(s, segId + 1, i + 1);
            } else {
                break;
            }
        }
    }
}
