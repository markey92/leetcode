package competition.year2020.day20200502;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200502
 * @ClassName: String5386
 * @Author: markey
 * @Description:
 * @Date: 2020/5/2 23:15
 * @Version: 1.0
 */
public class String5386 {

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc", "xya"));
    }
    public static boolean checkIfCanBreak(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return true;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < array2[i]) {
                char[] temp = array1;
                array1 = array2;
                array2 = temp;
            }
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < array2[i]) {
                return false;
            }
        }
        return true;
    }
}
