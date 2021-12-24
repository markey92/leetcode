package com.markey.leetcode.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode30
 * @Author: markey
 * @Description:
 * @Date: 2021/12/21 22:02
 * @Version: 1.0
 */
public class Leetcode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        // 记录目标单词的出现次数
        Map<String, Integer> wordNums = new HashMap<>();
        for (String word : words) {
            wordNums.put(word, wordNums.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length(); // 每个单词的长度
        int length = wordLength *  words.length; // 子串长度
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - length; i++) {
            // 枚举每个子串
            String temp = s.substring(i, i + length);
            Map<String, Integer> tempCount = new HashMap<>(); // 记录当前子串中，每个单词的出现次数
            boolean isRes = true;
            for (int j = 0; j < words.length; j++) {
                String word = temp.substring(j * wordLength, j * wordLength + wordLength);
                if (!wordNums.containsKey(word)) {
                    // 存在某个单词，不是目标单词；此子串不符合结果
                    isRes = false;
                    break;
                }
                tempCount.put(word, tempCount.getOrDefault(word, 0) + 1);
                if (tempCount.get(word) > wordNums.get(word)) {
                    // 存在某个单词，出现次数比预期的要多，此子串不符合结果
                    isRes = false;
                    break;
                }
                // 剩下的都是符合要求的子串
            }
            if (isRes) {
                res.add(i);
            }
        }
        return res;
    }
}
