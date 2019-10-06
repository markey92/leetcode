package queue;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Queue641
 * @Author: markey
 * @Description:
 * @Date: 2019/10/6 11:23
 * @Version: 1.0
 */
public class Queue641 {

    public static void main(String[] args) {
        MyCircularDeque2 circularDeque = new MyCircularDeque2(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));// 返回 true
        System.out.println(circularDeque.insertLast(2));// 返回 true
        System.out.println(circularDeque.insertFront(3));// 返回 true
        System.out.println(circularDeque.insertFront(4));// 已经满了，返回 false

        System.out.println(circularDeque.getRear());// 返回 2
        System.out.println(circularDeque.isFull());// 返回 true
        System.out.println(circularDeque.deleteLast());// 返回 true
        System.out.println(circularDeque.insertFront(4));// 返回 true
        System.out.println(circularDeque.getFront());// 返回 4
    }

    /**
     * 使用循环数组实现，
     * 记录队列的头和尾指针
     * 执行用时 :64 ms, 在所有 Java 提交中击败了92.38%的用户
     * 内存消耗 :38.6 MB, 在所有 Java 提交中击败了98.31%的用户
     */
    static class MyCircularDeque2 {

        int[] array;
        int head, tail, size, count;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque2(int k) {
            array = new int[k];
            head = 0;
            tail = 0;
            size = k;
            count = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head + size - 1) % size;
            array[head] = value;
            count ++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            array[tail] = value;
            tail = (tail + 1) % size;
            count ++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (this.isEmpty()) {
                return false;
            }
            head++;
            if (head >= size) head -= size;
            count --;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (this.isEmpty()) {
                return false;
            }
            tail--;
            if (tail < 0) tail += size;
            count --;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (this.isEmpty()) {
                return -1;
            }
            return array[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (this.isEmpty()) {
                return -1;
            }
            if (tail - 1 < 0) {
                return array[tail + size - 1];
            }
            return array[tail - 1];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return count == size;
        }
    }

    /**
     * 使用双栈实现双端队列
     * 一个栈的栈顶是头部元素，另一个栈的栈顶是尾部元素
     * 执行用时 :63 ms, 在所有 Java 提交中击败了93.81%的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了98.31%的用户
     */
    static class MyCircularDeque {

        Stack<Integer> head;
        Stack<Integer> tail;
        int size;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            head = new Stack<>();
            tail = new Stack<>();
            size = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (head.size() + tail.size() < size) {
                head.push(value);
                return true;
            }
            return false;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (head.size() + tail.size() < size) {
                tail.push(value);
                return true;
            }
            return false;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (head.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            if (head.isEmpty()) {
                return false;
            } else {
                head.pop();
                return true;
            }
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (tail.isEmpty()) {
                while (!head.isEmpty()) {
                    tail.push(head.pop());
                }
            }
            if (tail.isEmpty()) {
                return false;
            } else {
                tail.pop();
                return true;
            }
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (head.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            if (head.isEmpty()) {
                return -1;
            } else {
                return head.peek();
            }
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (tail.isEmpty()) {
                while (!head.isEmpty()) {
                    tail.push(head.pop());
                }
            }
            if (tail.isEmpty()) {
                return -1;
            } else {
                return tail.peek();
            }
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head.isEmpty() && tail.isEmpty();
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return head.size() + tail.size() >= size;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
