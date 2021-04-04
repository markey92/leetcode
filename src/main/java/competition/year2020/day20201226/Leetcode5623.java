package competition.year2020.day20201226;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201226
 * @ClassName: Leetcode5623
 * @Author: markey
 * @Description:
 * @Date: 2020/12/26 22:58
 * @Version: 1.0
 */
public class Leetcode5623 {
    public String maximumBinaryString1(String binary) {
        StringBuilder sb = new StringBuilder();
        StringBuilder binaryBuilder = new StringBuilder(binary);
        int nextZero = 1;
        for (int i = 0; i < binaryBuilder.length(); i++) {
            if (binaryBuilder.charAt(i) == '1') {
                sb.append('1');
            } else {
                nextZero = Math.max(i + 1, nextZero);
                while (nextZero < binaryBuilder.length() && binaryBuilder.charAt(nextZero) != '0') {
                    nextZero++;
                }
                if (nextZero >= binaryBuilder.length()) {
                    sb.append('0');
                } else {
                    binaryBuilder.setCharAt(nextZero, '1');
                    binaryBuilder.setCharAt(i + 1, '0');
                    sb.append('1');
                }
            }
        }
        return sb.toString();
    }
}
