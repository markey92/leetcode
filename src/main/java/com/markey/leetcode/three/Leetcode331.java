package com.markey.leetcode.three;

import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode331
 * @Author: markey
 * @Description:
 * @Date: 2021/3/12 20:00
 * @Version: 1.0
 */
public class Leetcode331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            if (!node.equals("#")) {
                stack.push(node);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().equals("#")) {
                if (stack.size() < 2) {
                    return false;
                }
                stack.pop();
                stack.pop();
            }
            stack.push(node);
        }
        return stack.isEmpty() || stack.size() == 1 &&stack.peek().equals("#");
    }
}
