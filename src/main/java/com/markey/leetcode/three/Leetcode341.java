package com.markey.leetcode.three;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode341
 * @Author: markey
 * @Description:
 * @Date: 2021/3/23 7:06
 * @Version: 1.0
 */
public class Leetcode341 {
    public class NestedIterator implements Iterator<Integer> {

        Stack<Iterator<NestedInteger>> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.stack = new Stack<>();
            this.stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return this.stack.pop().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                Iterator<NestedInteger> it = stack.peek();
                if (!it.hasNext()) {
                    stack.pop();
                    continue;
                }
                NestedInteger nest = it.next();
                if (nest.isInteger()) {
                    stack.push(Collections.singleton(nest).iterator());
                    return true;
                } else {
                    stack.push(nest.getList().iterator());
                }
            }
            return false;
        }
    }

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
}
