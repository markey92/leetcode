package competition.year2021.day20210123;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210123
 * @ClassName: Leetcode5646
 * @Author: markey
 * @Description:
 * @Date: 2021/1/23 22:38
 * @Version: 1.0
 */
public class Leetcode5646 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> can = new HashMap<>();
        for (int i = 1; i <= languages.length; i++) {
            Set<Integer> language = new HashSet<>();
            language.addAll(Arrays.stream(languages[i - 1]).boxed().collect(Collectors.toList()));
            can.put(i, language);
        }
        System.out.println(can);

        Set<Integer> canNoTalk = new HashSet<>();
        for (int i = 0; i < friendships.length; i++) {
            int x = friendships[i][0];
            int y = friendships[i][1];
            Set<Integer> xCan = can.get(x);
            Set<Integer> yCan = can.get(y);
            if (!canTalk(xCan, yCan)) {
                canNoTalk.add(x);
                canNoTalk.add(y);
            } else {
                System.out.println("can talk："+x + " " + y);
            }
        }

        System.out.println(canNoTalk);
        Map<Integer, Integer> languageIndex = new HashMap<>();
        for (int x : canNoTalk) {
            for (int language : can.get(x)) {
                languageIndex.put(language, languageIndex.getOrDefault(language, 0) + 1);
            }
        }

        System.out.println(languageIndex);
        int useSum = 0;
        for (Map.Entry<Integer, Integer> entry : languageIndex.entrySet()) {
            if (entry.getValue() > useSum) {
                useSum = entry.getValue();
            }
        }
        return canNoTalk.size() - useSum;
    }

    private boolean canTalk(Set<Integer> x, Set<Integer> y) {
        for (int item : x) {
            if (y.contains(item)) {
                return true;
            }
        }
        return false;
    }
}
