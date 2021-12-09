package competition.day20211107;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211107
 * @ClassName: Leetcode5918
 * @Author: markey
 * @Description:
 * @Date: 2021/11/7 10:30
 * @Version: 1.0
 */
public class Leetcode5918 {
    public int countVowelSubstrings(String word) {
        int res  = 0;
        boolean[] flag = new boolean[5];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (getIndex(word.charAt(j)) >= 0) {
                    flag[getIndex(word.charAt(j))] = true;
                    if (isMatch(flag)) {
                        res++;
                    }
                } else {
                    break;
                }
            }
            Arrays.fill(flag, false);
        }
        return res;
    }

    public boolean isMatch(boolean[] flags) {
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == false) {
                return false;
            }
        }
        return true;
    }

    public int getIndex(char c) {
        switch (c) {
            case 'a' : return 0;
            case 'e' : return 1;
            case 'i' : return 2;
            case 'o' : return 3;
            case 'u' : return 4;
            default: return -1;
        }
    }
}
