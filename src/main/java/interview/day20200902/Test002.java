package interview.day20200902;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20200902
 * @ClassName: Test002
 * @Author: markey
 * @Description:
 * @Date: 2020/9/2 20:32
 * @Version: 1.0
 */
public class Test002 {
    Map<Integer, Integer> cache = new HashMap<>();
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            int puzzleBin = 0;
            for (char c : puzzle.toCharArray()) {
                puzzleBin = puzzleBin | (1 << c - 'a');
            }
            if (cache.containsKey(puzzleBin)) {
                res.add(cache.get(puzzleBin));
                System.out.println("cache");
                continue;
            }
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[j].indexOf(puzzles[i].charAt(0)) < 0) {
                    continue;
                }
                int wordBin = 0;
                for (char c : words[j].toCharArray()) {
                    wordBin = wordBin | (1 << c - 'a');
                }
                count += ((wordBin & puzzleBin) ^ wordBin) == 0 ? 1 : 0;
            }
            cache.put(puzzleBin, count);
            res.add(count);
        }
        return res;
    }

    private boolean validWord(String puzzle, String word) {
//        for (int i = 0; i < 26; i++) {
//            char c = (char) ('a' + i);
//            if (word.indexOf(c) < 0) {
//                continue;
//            }
//            if (puzzle.indexOf(c) < 0) {
//                return false;
//            }
//        }
        int wordBin = 0;
        for (char c : word.toCharArray()) {
            wordBin = wordBin | (1 << c - 'a');
        }
        int puzzleBin = 0;
        for (char c : puzzle.toCharArray()) {
            puzzleBin = puzzleBin | (1 << c - 'a');
        }
        boolean result = ((wordBin & puzzleBin) ^ wordBin) == 0;
        return result;
    }
}
