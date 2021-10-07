package competition.year2021.day20210124;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210124
 * @ClassName: Leetcode5662
 * @Author: markey
 * @Description:
 * @Date: 2021/1/24 10:39
 * @Version: 1.0
 */
public class Leetcode5662 {
    public int minCharacters(String a, String b) {
        int res = a.length() + b.length() - maxNum(a, b);
        System.out.println(res);
        char minB = min(b);
        char minA = min(a);
        res = Math.min(res, bigger(a, minB));
        res = Math.min(res, bigger(b, minA));

        char maxA = max(a);
        res = Math.min(res, less(b, maxA));
        char maxB = max(b);
        res = Math.min(res, less(a, maxB));
        return res;

    }

    public int bigger(String x, char y) {
        int res = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) >= y) {
                res++;
            }
        }
        return res;
    }

    public int less(String x, char y) {
        int res = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) <= y) {
                res++;
            }
        }
        return res;
    }

    public int maxNum(String x, String y) {
        Map<Character, Integer> index = new HashMap<>();
        char maxChar = 'a';
        int maxNum = 0;
        for (char c : x.toCharArray()) {
            index.put(c, index.getOrDefault(c, 0) + 1);
            if (index.get(c) > maxNum) {
                maxChar = c;
                maxNum = index.get(c);
            }
        }
        for (char c : y.toCharArray()) {
            index.put(c, index.getOrDefault(c, 0) + 1);
            if (index.get(c) > maxNum) {
                maxChar = c;
                maxNum = index.get(c);
            }
        }
        return maxNum;
    }

    public char max(String x) {
        char res = x.charAt(0);
        for (int i = 1; i < x.length(); i++) {
            if (x.charAt(i) > res) {
                res = x.charAt(i);
            }
        }
        return res;
    }



    public char min(String x) {
        char res = x.charAt(0);
        for (int i = 1; i < x.length(); i++) {
            if (x.charAt(i) < res) {
                res = x.charAt(i);
            }
        }
        return res;
    }
}
