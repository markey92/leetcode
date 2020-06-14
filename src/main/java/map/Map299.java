package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: map
 * @ClassName: Map299
 * @Author: markey
 * @Description:
 * @Date: 2020/5/29 22:23
 * @Version: 1.0
 */
public class Map299 {
    public String getHint(String secret, String guess) {
        int countA = 0;
        int countB = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                countA++;
                continue;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && map.getOrDefault(guess.charAt(i), 0) > 0) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                countB++;
            }
        }
        return countA + "A" + countB + "B";
    }
}
