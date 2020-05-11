package competition.day20200419;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200419
 * @ClassName: String5390
 * @Author: markey
 * @Description:
 * @Date: 2020/4/19 11:01
 * @Version: 1.0
 */
public class String5390 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] letter = new int[5];
        int max = 0;
        for (Character c: croakOfFrogs.toCharArray()) {
            switch (c) {
                case 'c' : letter[0] += 1; break;
                case 'r' : letter[1] += 1; break;
                case 'o' : letter[2] += 1; break;
                case 'a' : letter[3] += 1; break;
                case 'k' : letter[4] += 1; break;
            }
            max = Math.max(max, letter[0] - letter[4]);
            max = Math.max(max, letter[1] - letter[4]);
            max = Math.max(max, letter[2] - letter[4]);
            max = Math.max(max, letter[3] - letter[4]);

            for (int i = 1; i < 5; i++) {
                if (letter[i-1] < letter[i]) {
                    return -1;
                }
            }
        }
        for (int i = 1; i < letter.length; i++) {
            if (letter[i] != letter[i-1]) {
                return -1;
            }
        }
        return max;
    }
}
