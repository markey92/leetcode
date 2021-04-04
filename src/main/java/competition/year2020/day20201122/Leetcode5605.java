package competition.year2020.day20201122;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201122
 * @ClassName: Leetcode5605
 * @Author: markey
 * @Description:
 * @Date: 2020/11/22 10:30
 * @Version: 1.0
 */
public class Leetcode5605 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            stringBuilder1.append(word1[i]);
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            stringBuilder2.append(word2[i]);
        }

        return stringBuilder1.toString().equals(stringBuilder2.toString());
    }
}
