package competition.day20210320;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210320
 * @ClassName: Leetcode5694
 * @Author: markey
 * @Description:
 * @Date: 2021/3/20 22:34
 * @Version: 1.0
 */
public class Leetcode5694 {
    class AuthenticationManager {
        int timeToLive;
        Map<String, Integer> tokens;
        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.tokens = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (tokens.containsKey(tokenId) && tokens.get(tokenId) > currentTime) {
                tokens.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            System.out.println(tokens);
            return (int) tokens.values().stream().filter(expiredTime -> expiredTime > currentTime).count();
        }
    }
}
