package stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Stack341 {


public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();
     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack;
        List<NestedInteger> nestedList;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            return getNext().getInteger();
        }

        public NestedInteger getNext() {
            List<NestedInteger> temp;
            if (stack.isEmpty() && !nestedList.isEmpty()) {
                stack.push(nestedList.remove(0));
            }
            while (!stack.peek().isInteger()){
                temp = stack.peek().getList();
                if (temp.size() > 0) {
                    stack.push(temp.remove(0));
                } else {
                    stack.pop();
                }
                if (stack.isEmpty() && !nestedList.isEmpty()) {
                    stack.push(nestedList.remove(0));
                }
            }
            if (stack.isEmpty()) return null;
            return stack.pop();
        }
        @Override
        public boolean hasNext() {
            NestedInteger nestedInteger = this.getNext();
            if (nestedInteger != null) {
                return false;
            } else {
                stack.push(nestedInteger);
                return true;
            }
        }
    }

}
