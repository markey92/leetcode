package competition.year2020.day20201031;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201031
 * @ClassName: Leetcode5542
 * @Author: markey
 * @Description:
 * @Date: 2020/10/31 23:01
 * @Version: 1.0
 */
public class Leetcode5542 {
    // 超时
    public int numWays(String[] words, String target) {
        List<int[]> wordList = new ArrayList<>();
        for (int i = 0; i < words[0].length(); i++) {
            int[] count = new int[26];
            for (int j = 0; j < words.length; j++) {
                char c = words[j].charAt(i);
                count[c - 'a']++;
            }
            wordList.add(count);
        }
        return (int) numWays(wordList, target, words[0].length() - 1, target.length() - 1);
    }
    public long numWays(List<int[]> wordList, String target, int wordIndex, int targetIndex) {
        if (targetIndex < 0) {
            return 1;
        }
        if (wordIndex < 0) {
            return 0;
        }
        long res = 0;
        while (wordIndex >=0 && wordIndex >= targetIndex) {
            char c = target.charAt(targetIndex);
            if (wordList.get(wordIndex)[c - 'a'] > 0) {
                res += wordList.get(wordIndex)[c - 'a'] * numWays(wordList, target, wordIndex - 1, targetIndex - 1);
            }
            wordIndex--;
        }
        return res % 1000000007;
    }
}
