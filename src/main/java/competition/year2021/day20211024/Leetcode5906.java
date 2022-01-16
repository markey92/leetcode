package competition.year2021.day20211024;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211024
 * @ClassName: Leetcode5906
 * @Author: markey
 * @Description:
 * @Date: 2021/10/24 10:36
 * @Version: 1.0
 */
public class Leetcode5906 {
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int res = 0;
        for (String word : words) {
            if (isWord(word)) {
                System.out.println(word);
                res++;
            } else {
//                System.out.println(word);
            }
        }
        return res;
    }

    private boolean isWord(String word) {
        if (word.length() == 0) {
            return false;
        }
        if (word.contains("-")) {
            int index = word.indexOf('-');
            char last = word.charAt(word.length() - 1);
            return isLetterWord(word.substring(0, index)) && isLetterWordAndLast(word.substring(index + 1));
        }
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                return false;
            }
        }
        char last = word.charAt(word.length() - 1);
        if ((last >= 'a' && last <= 'z') || last == '!' || last == '.' || last == ',') {
            return true;
        }
        return false;
    }

    private boolean isLetterWord(String word) {
        if (word.length() == 0) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }

    private boolean isLetterWordAndLast(String word) {
        if (word.length() == 0) {
            return false;
        }
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                return false;
            }
        }
        char last = word.charAt(word.length() - 1);
        if ((last >= 'a' && last <= 'z')) {
            return true;
        }
        if (last == '!' || last == '.' || last == ',') {
            return word.length() > 1;
        }
        return false;
    }
}
