package competition.day20210418;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210418
 * @ClassName: Leetcode5737
 * @Author: markey
 * @Description:
 * @Date: 2021/4/18 11:19
 * @Version: 1.0
 */
public class Leetcode5737 {
    public static void main(String[] args) {
        System.out.println(6^5);
        System.out.println(1^2^3);
        System.out.println();
        System.out.println(getXORSum(new int[]{1,2,3}, new int[]{6,5}));
        System.out.println(getXORSum(new int[]{12}, new int[]{4}));
        System.out.println(getXORSum(new int[]{12}, new int[]{4,2}));
    }
    public static int getXORSum(int[] arr1, int[] arr2) {
//        int res = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                res ^= (arr1[i] & arr2[j]);
//            }
//        }
//        return (int) res;
        int x = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            x ^= arr2[i];
        }
        int y = arr1[0] & x;
        for (int i = 1; i < arr1.length; i++) {
            y ^= arr1[i];
        }
        return x & y;
    }
}
