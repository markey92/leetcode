package sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: SortTest
 * @Author: markey
 * @Description:
 * @Date: 2020/3/17 23:07
 * @Version: 1.0
 */
public class SortTest {


    public static void main(String[] args) {

        int[] sourceArray;

        // 冒泡排序
        sourceArray = new int[] {1,3,2,3,4,2};
        Sort bubbleSort = new BubbleSort();
        String bubbleSortResult = Arrays.toString(bubbleSort.sort(sourceArray));
//        System.out.println(bubbleSortResult);

        // 选择排序
        sourceArray = new int[] {1,3,2,3,4,2};
        Sort selectSort = new SelectSort();
        String selectSortResult = Arrays.toString(selectSort.sort(sourceArray));
//        System.out.println(selectSortResult);

        // 插入排序
        sourceArray = new int[] {1,5,6,3,4,2};
        Sort insertSort = new InsertSort();
        String insertSortResult = Arrays.toString(insertSort.sort(sourceArray));
//        System.out.println(insertSortResult);

        // 希尔排序
        sourceArray = new int[] {1,5,6,8,3,4,2,7};
        Sort shellSort = new ShellSort();
        String shellSortResult = Arrays.toString(shellSort.sort(sourceArray));
//        System.out.println(shellSortResult);

        // 堆排序
        sourceArray = new int[] {1,3,2,3,4,2};
        Sort heapSort = new HeapSort();
        String heapSortResult = Arrays.toString(heapSort.sort(sourceArray));
//        System.out.println(heapSortResult);
    }
}
