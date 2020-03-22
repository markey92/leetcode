package sort;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: ShellSort
 * @Author: markey
 * @Description:
 * @Date: 2020/3/18 23:39
 * @Version: 1.0
 */
public class ShellSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        System.out.println(Arrays.toString(array));
        int gap = array.length / 2;
        while (gap > 0) {
            System.out.println("gap:" + gap);
            for (int i = 0; i < gap; i++) {
                sort(array, i, gap);
            }
            System.out.println(Arrays.toString(array));
            gap /= 2;
        }
        return array;
    }

    // 插入排序
    private void sort(int[] array, int start,  int gap) {
        for (int i = start; i < array.length; i += gap) {
            int temp = array[i];
            for (int j = i; j >= 0; j-= gap) {
                if (j - gap > 0 && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                } else {
                    array[j] = temp;
                    break;
                }
            }
        }
    }
}
