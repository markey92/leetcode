package competition.year2021.day20211017;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211017
 * @ClassName: Leetcode5902
 * @Author: markey
 * @Description:
 * @Date: 2021/10/17 10:32
 * @Version: 1.0
 */
public class Leetcode5902 {
    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int lastNum = -1;
        for (int i = 0; i < words.length; i++) {
            try {
                int num = Integer.parseInt(words[i]);
                if (num <= lastNum) {
                    return false;
                }
                lastNum = num;
            } catch (Exception e) {

            }
        }
        return true;
    }
}
