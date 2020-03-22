package sort;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: InsertSort
 * @Author: markey
 * @Description:
 * @Date: 2020/3/17 22:33
 * @Version: 1.0
 */
public class InsertSort implements Sort{
    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {
            int temp = sourceArray[i];
            for (int j = i - 1; j >= 0; j--) {
                if (sourceArray[j] > temp) {
                    sourceArray[j + 1] = sourceArray[j];
                } else {
                    sourceArray[j + 1] = temp;
                    break;
                }
            }
        }
        return sourceArray;
    }
}
