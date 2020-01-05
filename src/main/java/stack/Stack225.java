package stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class Stack225 {

    static class MyStack2 {
        Queue<Integer> queue;
        int size;
        /** Initialize your data structure here. */
        public MyStack2() {
            queue = new ArrayDeque();
            size = 0;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            size = queue.size();
            queue.add(x);
            while (size > 0) {
                queue.add(queue.poll());
                size--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    static class MyStack {
        Queue<Integer> queue1, queue2;
        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new ArrayDeque();
            queue2 = new ArrayDeque();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (!queue1.isEmpty()) {
                queue1.add(x);
            } else {
                queue2.add(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            } else {
                while (queue1.size() > 1) {
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            int result;
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.add(queue2.poll());
                }
                result = queue2.poll();
                queue1.add(result);
            } else {
                while (queue1.size() > 1) {
                    queue2.add(queue1.poll());
                }
                result = queue1.poll();
                queue2.add(result);
            }
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
