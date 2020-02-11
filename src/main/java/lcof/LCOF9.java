package lcof;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: swordFingerOffer
 * @ClassName: Sword9
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 22:05
 * @Version: 1.0
 */
public class LCOF9 {
    class CQueue {
        Stack<Integer> stackIn, stackOut;
        public CQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.isEmpty() ? -1 : stackOut.pop();
        }
    }
}
