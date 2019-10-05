package num;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Num263
 * @Author: markey
 * @Description:
 * @Date: 2019/10/3 11:17
 * @Version: 1.0
 */
public class Num263 {

    public static void main(String[] args) {
        System.out.println(isUgly(1));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.5 MB, 在所有 Java 提交中击败了13.14%的用户
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        int [] primeList = {1, 2, 3, 5};
        int temp = 0;
        while (num != temp) {
            temp = num;
            for (int i = 0; i < primeList.length; i++) {
                if (num % primeList[i] == 0) {
                    num /= primeList[i];
                }
            }
        }
        return num == 1;
    }
}
