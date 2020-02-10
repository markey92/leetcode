package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array5332
 * @Author: markey
 * @Description:
 * @Date: 2020/2/9 10:36
 * @Version: 1.0
 */
public class Array5332 {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[] {7,1,14,11}));
    }
    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2)) {
                return true;
            }
            if (set.contains(arr[i] / 2) && arr[i] % 2 == 0) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
