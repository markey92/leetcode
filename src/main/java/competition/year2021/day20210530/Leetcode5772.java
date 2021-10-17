package competition.year2021.day20210530;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210530
 * @ClassName: Leetcode5772
 * @Author: markey
 * @Description:
 * @Date: 2021/5/30 10:35
 * @Version: 1.0
 */
public class Leetcode5772 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);

    }

    private int getNum(String word) {
        int res = 0;
        for (char c : word.toCharArray()) {
            res = res * 10 + c - 'a';
        }
        return res;
    }
}
