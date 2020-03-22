package sort;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: HeadSort
 * @Author: markey
 * @Description:
 * @Date: 2020/3/16 23:05
 * @Version: 1.0
 */
public class HeapSort implements Sort{
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;

        buildMaxHeap(arr, len);

        // 把最大值放到最后一格（最后一格和第一个对调），剩下的重新调整最大堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        // 调整除叶子节点外的所有节点，使符合最大堆
        for (int i = (int) Math.floor(len / 2); i >=0 ; i--) {
            heapify(arr, i, len);
        }
    }

    // 调整最大堆
    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

}
