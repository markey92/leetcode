package sort;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: BubbleSort
 * @Author: markey
 * @Description:
 * @Date: 2020/3/17 23:06
 * @Version: 1.0
 */
public class BubbleSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
        return array;
    }
}
