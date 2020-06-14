package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: queue
 * @ClassName: Queue03_06
 * @Author: markey
 * @Description:
 * @Date: 2020/6/4 21:48
 * @Version: 1.0
 */
public class Queue03_06 {
    class AnimalShelf {
        Queue<Integer> cats;
        Queue<Integer> dogs;
        public AnimalShelf() {
            cats = new LinkedList<>();
            dogs = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                cats.offer(animal[0]);
            } else {
                dogs.offer(animal[0]);
            }
        }

        public int[] dequeueAny() {
            int[] res = new int[] {-1, -1};
            if (dogs.size() <= 0 && cats.size() <= 0) {
                return res;
            }
            if (dogs.size() == 0) {
                return new int[] {cats.poll(), 0};
            } else if (cats.size() == 0){
                return new int[] {dogs.poll(), 1};
            } else {
                if (cats.peek() > dogs.peek()) {
                    return new int[] {dogs.poll(), 1};
                } else {
                    return new int[] {cats.poll(), 0};
                }
            }
        }

        public int[] dequeueDog() {
            if (dogs.size() > 0) {
                return new int[]{dogs.poll(), 1};
            } else {
                return new int[] {-1, -1};
            }
        }

        public int[] dequeueCat() {
            if (cats.size() > 0) {
                return new int[]{cats.poll(), 0};
            } else {
                return new int[] {-1, -1};
            }
        }
    }

}
