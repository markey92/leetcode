package sort;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: SelectSort
 * @Author: markey
 * @Description:
 * @Date: 2020/3/17 23:41
 * @Version: 1.0
 */
public class SelectSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int max;
        for (int i = array.length - 1; i > 0 ; i--) {
            max = i;
            for (int j = 0; j <= i; j++) {
                if (array[i] > max) {
                    max = i;
                }
            }
            if (max != i) {
                swap(array, max, i);
            }
        }
        return array;
    }

}
