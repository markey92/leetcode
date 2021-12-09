package competition.day20211114;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211114
 * @ClassName: Leetcode5928
 * @Author: markey
 * @Description:
 * @Date: 2021/11/14 11:02
 * @Version: 1.0
 */
public class Leetcode5928 {
    public String decodeCiphertext(String encodedText, int rows) {
        int col = encodedText.length() / rows;
        char[][] matrix = new char[rows][col];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = encodedText.charAt(index);
                index++;
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('0');
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < rows; i++) {
                if (j + i < col) {
                    stringBuilder.append(matrix[i][j + i]);
                }
            }
        }
        return stringBuilder.toString().trim().substring(1);
    }
}
