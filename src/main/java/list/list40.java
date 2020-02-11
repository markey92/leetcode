package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: list
 * @ClassName: list40
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 21:37
 * @Version: 1.0
 */
public class list40 {

    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack1.isEmpty()) {
                stack1.push(arr[i]);
                continue;
            }
            while (!stack1.isEmpty()) {
                if (stack1.peek() <= arr[i]) {
                    break;
                }
                stack2.push(stack1.pop());
            }
            stack1.push(arr[i]);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            while (stack1.size() > k) {
                stack1.pop();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!stack1.isEmpty()) {
                res[i] = stack1.pop();
            }
        }
        return res;
    }
}
