package competition.year2021.day20211121;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.year2021.day20211121
 * @ClassName: Leetcode5186
 * @Author: markey
 * @Description:
 * @Date: 2021/11/21 10:46
 * @Version: 1.0
 */
public class Leetcode5186 {
    class RangeFreqQuery {
        private Map<Integer, List<Integer>> listMap;
        public RangeFreqQuery(int[] arr) {
            listMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!listMap.containsKey(arr[i])) {
                    listMap.put(arr[i], new ArrayList<>());
                }
                listMap.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = listMap.get(value);
            if (list == null || right < list.get(0) || left > list.get(list.size() - 1)) {
                return 0;
            }
            int min = binarySearchLeft(list, 0, list.size() - 1, left);
            int max = binarySearchRight(list, 0, list.size() - 1, right);
            System.out.println(list);
            System.out.println(min);
            System.out.println(max);
            return Math.max(0, max - min + 1);
        }

        private int binarySearchLeft(List<Integer> list, int left, int right, int target) {
            if (left >= right) {
                return right;
            }
            int mid = (right + left) / 2;
            if (list.get(mid) >= target) {
                return binarySearchLeft(list, left, mid, target);
            } else {
                return binarySearchLeft(list, mid + 1, right, target);
            }
        }

        private int binarySearchRight(List<Integer> list, int left, int right, int target) {
            if (left >= right) {
                return list.get(right);
            }
            int mid = (right + left + 1) / 2;
            if (list.get(mid) <= target) {
                return binarySearchRight(list, mid, right, target);
            } else {
                return binarySearchRight(list, left, mid - 1, target);
            }
        }
    }

}
