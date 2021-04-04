package competition.year2020.day20200502;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200502
 * @ClassName: Num5385
 * @Author: markey
 * @Description:
 * @Date: 2020/5/2 22:37
 * @Version: 1.0
 */
public class Num5385 {
    public static void main(String[] args) {
        System.out.println(maxDiff(123456));
    }
    public static int maxDiff(int num) {
        if (num == 0) {
            return 8;
        }
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }
        int head = stack.pop();
        int res = 8;
        if (head == 1) {
            int firstNotZero = 0;
            while (!stack.isEmpty()) {
                int temp = stack.pop();
                if (firstNotZero == 0 && temp != head && temp != 0) {
                    firstNotZero = temp;
                }
                if (temp == head) {
                    res = res * 10 + (9 - temp);
                } else {
                    res = res * 10 + (temp == firstNotZero ? firstNotZero : 0);
                }
            }
        } else if (head == 9) {
            int firstNotNine = 9;
            while (!stack.isEmpty()) {
                int temp = stack.pop();
                if (firstNotNine == 9 && temp != 9) {
                    firstNotNine = temp;
                }
                if (temp == 9) {
                    res = res * 10 + 8;
                } else {
                    res = res * 10 + (temp == firstNotNine ? 9 - firstNotNine : 0);
                }
            }
        } else {
            while (!stack.isEmpty()) {
                res = res * 10 + (stack.pop() == head ? 8 : 0);
            }
        }

        return res;
    }
}
