package competition.year2021.day20210403;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210403
 * @ClassName: Leetcode5706
 * @Author: markey
 * @Description:
 * @Date: 2021/4/3 22:34
 * @Version: 1.0
 */
public class Leetcode5706 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int start = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(s2[i])) {
                start++;
            } else {
                break;
            }
        }
        int end = 0;
        for (int i = 1; i <= s1.length; i++) {
            if (s1[s1.length - i].equals(s2[s2.length - i])) {
                end++;
            } else {
                break;
            }
        }
        System.out.println(start + ":" + end);
        return start + end >= s1.length;
    }
}
